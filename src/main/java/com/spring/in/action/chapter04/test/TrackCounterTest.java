package com.spring.in.action.chapter04.test;

import com.spring.in.action.chapter04.CompactDisc;
import com.spring.in.action.chapter04.TrackCountConfig;
import com.spring.in.action.chapter04.TrackCounter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/31 09:23
 * @since 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCountConfig.class)
public class TrackCounterTest {

    @Autowired
    private CompactDisc cd;
    @Autowired
    private TrackCounter counter;

    @Test
    public void testTrackCounter() {
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(3);

        assert 1 == counter.getPlayCount(1);
        assert 1 == counter.getPlayCount(2);
        assert 2 == counter.getPlayCount(3);

    }
}
