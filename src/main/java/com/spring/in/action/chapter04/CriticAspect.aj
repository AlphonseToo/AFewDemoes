package com.spring.in.action.chapter04;

public aspect CriticAspect {
    public CriticAspect() {}

    pointcut performance() : execution(* perform(..));

}
