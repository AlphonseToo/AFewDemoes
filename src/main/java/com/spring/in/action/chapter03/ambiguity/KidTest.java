package com.spring.in.action.chapter03.ambiguity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/24 15:59
 * @since 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Kid.class)
public class KidTest {
    @Autowired
    Kid kid;

    @Test
    public void test() {
        System.out.println(kid);
    }
}
