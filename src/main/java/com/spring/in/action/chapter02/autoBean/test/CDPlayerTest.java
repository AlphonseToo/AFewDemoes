package com.spring.in.action.chapter02.autoBean.test;

import com.spring.in.action.chapter02.autoBean.CDPlayerConfig;
import com.spring.in.action.chapter02.autoBean.CompactDisc;
import com.spring.in.action.chapter02.autoBean.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/23 15:20
 * @since 1.0
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CDPlayerConfig.class})
public class CDPlayerTest {
    @Autowired
    private CompactDisc compactDisc;
    @Autowired
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
