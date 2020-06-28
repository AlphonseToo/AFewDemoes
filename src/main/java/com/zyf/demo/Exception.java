package com.zyf.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2020/6/28 17:39
 * @since 1.0
 **/
@Slf4j
public class Exception {
    public static void main(String[] args) {
        try {
            System.out.println(1/0);
        } catch (java.lang.Exception e) {
            log.error(e.getMessage(), e.getCause());
            System.out.println("-----------------------------------------");
            log.error(e.getMessage(), e);
            System.out.println("-----------------------------------------");
            log.error("error:",e.getMessage(),e);
            System.out.println("-----------------------------------------");
        }
    }
}
