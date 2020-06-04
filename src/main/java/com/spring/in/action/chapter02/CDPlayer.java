package com.spring.in.action.chapter02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/23 15:59
 * @since 1.0
 **/
@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired
    public CDPlayer(@Qualifier(value = "sgt1") CompactDisc cd) {
        this.cd = cd;
    }
    public void play() {
        cd.play();
    }
    @Bean
    public String cdTitle(){
        System.out.println("这里是题目");
        return "A amn";
    }

    public CompactDisc randomBeatlesCD(){
        int choice = (int)Math.floor(Math.random()*4);
        if (choice == 0)
            return new SgtPeppers();
        else if (choice == 1)
            return null;
        return null;
    }
}
