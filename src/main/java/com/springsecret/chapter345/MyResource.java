package com.springsecret.chapter345;

import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyResource
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/12 11:25
 **/
public class MyResource extends AbstractResource {

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

    public static void main(String[] args) {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resource = defaultResourceLoader.getResource("C:\\Users\\DELL\\Desktop\\UC查询.xmind");
        boolean a = resource.exists();
        System.out.println(a);
        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        Resource resource1 = fileSystemResourceLoader.getResource("C:\\Users\\DELL\\Desktop\\UC查询.xmind");
        System.out.println(resource1.exists());
    }
}
