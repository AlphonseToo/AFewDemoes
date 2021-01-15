package com.thinking.demo.chapter17;

import java.lang.reflect.Array;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/21 17:25
 * @since 1.0
 **/

class SList<T> {
    private int capacity = 1;
    private int size = 0;
    private T[] element;

    public SList(Class<T> c) {
        element = (T[]) Array.newInstance(c, capacity);
    }

    public SListIterator<T> iterator() {
        return new SListIterator<>(size, capacity, element);
    }
    public T get(int index) {
        return element[index];
    }
    public int size() { return size; }

}
class SListIterator<T>{
    private int index;
    private int length;
    private int capacity;
    private T[] element;

    public SListIterator(int length, int capacity, T[] element) {
        this.length = length;
        this.element = element;
        this.capacity = capacity;
    }

    public boolean hasNext() {
        if(index < length) return true;
        return false;
    }
    public T next() {
        return element[index++];
    }
    //在list末端添加元素
    public void add(T t) {
        if(length < capacity)
            element[length++] = t;
        else {
            capacity *= 2;
            element = move(length, element, capacity);
            element[length++] = t;
            System.out.println("【info】列表数组已满，长度自动扩充为原来的一倍：" + capacity/2 + "扩充为" + capacity);
        }
    }
    // 移除末端元素
    public void remove(){
        if(length == 0)
            throw new RuntimeException("非法操作：该列表已经为空。");
        if(--length <= capacity/4) {
            capacity /= 2;
            element = move(length, element, capacity);

            System.out.println("【info】列表数组长度已自动减为原来的一半：" + capacity*2 + "->" + capacity);
        }
    }
    private T[] move(int end, T[] old, int capacity) {
        T[] newList = (T[])Array.newInstance(element[0].getClass(), capacity);
        for(int i = 0;i < end;i++)
            newList[i] = old[i];
        return newList;
    }
}
public class E8 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        SList<String> sList = new SList<>(String.class);
        SListIterator iterator = sList.iterator();
        iterator.add("1111");
        iterator.add("2222");
        iterator.add("3333");
        iterator.add("4444");
        iterator.add("5555");
        iterator.add("6666");
        iterator.add("7777");
        iterator.add("8888");
        while(iterator.hasNext()) {
            String s = (String) iterator.next();
            if(s.equals("5555"))
                iterator.remove();
            System.out.println(s);
        }

        iterator.remove();
        iterator.remove();
        iterator.remove();
        iterator.remove();
        iterator.remove();
    }
}
