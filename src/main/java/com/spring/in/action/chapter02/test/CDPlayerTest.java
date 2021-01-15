package com.spring.in.action.chapter02.test;

import com.spring.in.action.chapter02.CDPlayerConfig;
import com.spring.in.action.chapter02.CompactDisc;
import com.spring.in.action.chapter02.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/12/23 15:20
 * @since 1.0
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CDPlayerConfig.class})
public class CDPlayerTest {
    @Resource(name = "sgt1")
    private CompactDisc compactDisc;
    @Autowired
    @Qualifier(value = "CDPlayer")
    private MediaPlayer mp;


    @Test
    public void cdShould(){
        assert compactDisc != null;
        compactDisc.play();

    }

    @Test
    public void play() {
        mp.play();
        System.out.println(mp.cdTitle());
    }
}
