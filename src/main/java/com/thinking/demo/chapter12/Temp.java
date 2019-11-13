package com.thinking.demo.chapter12;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/7 17:03
 * @since 1.0
 **/
class Casd {
    public Casd() {
        System.out.println("Here");
    }
    public int fc(int j){
        return 10/j;
    }
    public int fun(int i){
        int result = 0;
        try{
            if(i == 0)
                throw new IllegalArgumentException("除数为0");
            //result = 10/i;
            return 1;
        }catch (Exception e) {
            //throw new IllegalArgumentException("ssfs");
            System.out.println(e);
            return 2;
        }finally {
            System.out.println(12);
            return 3;
        }
        //System.out.println("here");
        //return result;
    }
    public Casd(String s) {
        System.out.println("Here" + s);
    }
}
public class Temp extends Casd {
    public Temp(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Temp temp = new Temp("haha");
        try{
            System.out.println(temp.fc(0));
        }catch (RuntimeException e) {
            try{
                throw e.getCause();
            }catch (ArithmeticException ce){
                System.out.println("算术异常：" + ce);
            }catch (Throwable t) {
                System.out.println(e);
            }
        }
    }
}
