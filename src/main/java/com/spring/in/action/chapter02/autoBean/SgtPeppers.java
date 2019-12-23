package com.spring.in.action.chapter02.autoBean;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/23 15:10
 * @since 1.0
 **/

@Component
public class SgtPeppers implements CompactDisc{
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";
    @Override
    public void play() {
        System.out.println("Playing " + title + "by " + artist);
    }
}
