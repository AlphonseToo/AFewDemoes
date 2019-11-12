package com.thinking.demo.chapter11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * ~~~~~~~
 *
 * @author Alphonse
 * @date 2019/11/1 13:57
 * @since 1.0
 **/

class Element{
    public static final Random random = new Random(88);
    int i;

    public Element() {
        i = random.nextInt(100);
    }

    @Override
    public String toString() {
        return "Element{" +
                "i=" + i +
                '}';
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
public class E07 {
    static void init(List<Element> arr){
        arr.add(new Element());
        arr.add(new Element());
        arr.add(new Element());
        arr.add(new Element());
    }
    public static void main(String[] args) {
        List<Element> arr = new ArrayList<>();
        init(arr);
        System.out.println(arr.toString());
        ListIterator<Element> it = arr.listIterator();
        System.out.println("S: " + it.previousIndex() + " C: " + it.nextIndex() + " next: " + it.next());
        List<Element> subList = arr.subList(1, 2);
        System.out.println(subList.toString());
        arr.removeAll(subList);
        System.out.println(arr.toString());
        LinkedList<Element> li = new LinkedList<>(arr);
        li.add(li.size()/2, new Element());
        System.out.println(li.toString());
    }
}
