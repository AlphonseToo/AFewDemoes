package com.spring.in.action.chapter05;

import java.util.List;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2020/1/7 15:42
 * @since 1.0
 **/
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
