package com.spring.in.action.chapter01;

/**
 * yi
 *
 * @author Alphonse
 * @date 2020/6/1 14:53
 * @since 1.0
 **/
public class KnightMain {
    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("chapter1.xml");
        DamselRescuingKnight knight = context.getBean(DamselRescuingKnight.class);
        knight.embarkOnQuest();
        context.close();*/
        Quest quest = new RescueDamselQuest("1");
        Knight knight = new DamselRescuingKnight(quest);
        ((DamselRescuingKnight) knight).embarkOnQuest();
    }
}
