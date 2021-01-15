package com.thinking.demo.chapter15;

import java.util.ArrayList;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/18 11:13
 * @since 1.0
 **/
class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;
        Node() {
            this.item = null;
            this.next = null;
        }
        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
        boolean end() {
            return item == null && next == null;
        }
    }
    private Node<T> top = new Node<>();
    public void push(T item) {
        top = new Node<>(item, top);
    }
    public T pop() {
        T result = top.item;
        if(!top.end())
            top = top.next;
        return result;
    }
    public ArrayList<T> list = new ArrayList<>();
    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for(String s : "psaki id ko lk".split(" "))
            lss.push(s);
        String s;
        while((s = lss.pop()) != null) {
            System.out.println(s);
        }
    }
}
public class T1 {
    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.list.add("In");
        linkedStack.list.add(45);
        linkedStack.list.add(45.2365);
        System.out.println(linkedStack.list);

    }
}
