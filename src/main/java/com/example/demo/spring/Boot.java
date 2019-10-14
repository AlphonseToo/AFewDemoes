package com.example.demo.spring;

import lombok.Data;

/**
 * @ClassName: Boot
 * @Description: boot
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/10/14 10:52
 **/
@Data
public class Boot {
    private String player;
    private int level;

    public Boot() {
        this.player = "独孤求败";
        this.level = 49;
    }

    public Boot(String player, int level) {
        this.player = player;
        this.level = level;
    }
}
