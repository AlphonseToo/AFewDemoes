package com.thinking.demo.chapter14;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/13 13:42
 * @since 1.0
 **/
public class E8 {
    void print(Shape shape){
        if(shape.getClass().getSuperclass() != null) {
            System.out.println(shape.getClass().getSuperclass());

        }
    }
    static void printClass(Class cc){
        if(cc.getSuperclass() != null) {
            try {
                System.out.println(cc);
            } catch (Exception e) {
                e.printStackTrace();
            }
            printClass(cc.getSuperclass());
        }
    }

    public static void main(String[] args) throws Exception{
        String sname = "Circle";
        printClass(Class.forName("com.thinking.demo.chapter14." + sname));
    }
}
