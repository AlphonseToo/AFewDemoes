package com.zyf.demo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * NacosConfig
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/19 15:56
 **/
//@ConfigurationProperties("local.nacos")
public class NacosConfig {
    private String username;
    private String password;

    public static void main(String[] args) throws Exception {
        String dataId = "{public}";
        String group = "{1.3}";
        Properties property = new Properties();
        property.put("serverAddr", "127.0.0.1:8848");
        ConfigService configService = NacosFactory.createConfigService(property);
        String config = configService.getConfig(dataId, group, 1000);
        System.out.println(config);

        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("Received:" + configInfo);
            }
            @Override
            public Executor getExecutor() {
                return null;
            }
        });
    }
}
