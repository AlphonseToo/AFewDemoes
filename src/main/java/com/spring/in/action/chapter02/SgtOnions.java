package com.spring.in.action.chapter02;

import org.springframework.stereotype.Component;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/12/23 15:53
 * @since 1.0
 **/
@Component("sgt1")
public class SgtOnions implements CompactDisc {
    @Override
    public void play() {
        System.out.println("Onion is Onion" + i);
    }
}
