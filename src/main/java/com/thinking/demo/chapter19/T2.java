package com.thinking.demo.chapter19;

import java.util.EnumMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/28 13:45
 * @since 1.0
 **/

enum Shrubbry {
    GROUND("An akl"), CRAWLING("A bee"), HANGING("A cook");
    private String description;

    Shrubbry(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Shrubbry{" +
                "description='" + description + '\'' +
                '}';
    }}
class EnumClass {
    public static void main(String[] args) {
        for(Shrubbry s : Shrubbry.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.println(s.compareTo(Shrubbry.CRAWLING));
            System.out.println(s.equals(Shrubbry.CRAWLING));
            System.out.println(s.getDeclaringClass());
            System.out.println(s.getClass());
            System.out.println("************************");
        }
        Enum[] enums = Shrubbry.CRAWLING.getClass().getEnumConstants();
        System.out.println(enums);
    }
}

interface Command {
    void action();
}
class EnumMaps {
    public static void main(String[] args) {
        EnumMap<Alarmpoints, Command> em = new EnumMap<>(Alarmpoints.class);
        em.put(Alarmpoints.BATHROOM, new Command() {
            @Override
            public void action() {
                System.out.println(" Bathroom fire");
            }
        });
        em.put(Alarmpoints.OFFICE1, new Command() {
            @Override
            public void action() {
                System.out.println(" Office lost");
            }
        });
        for(Map.Entry<Alarmpoints, Command> me : em.entrySet()) {
            System.out.print(me.getKey());
            me.getValue().action();
        }
    }
}

public class T2 {
}
