package com.thinking.demo.chapter19;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/2 08:55
 * @since 1.0
 **/

enum Animal {
    DOG, PIG, CAT, Lion
}

public class N1 {
    public static void main(String[] args) {
        for(Animal animal : Animal.values()) {
            System.out.print(animal + " ordinal: " + animal.ordinal() + "\t");
            System.out.print(animal.getDeclaringClass() + "\t");
            System.out.println(animal.name());

        }
    }
}
