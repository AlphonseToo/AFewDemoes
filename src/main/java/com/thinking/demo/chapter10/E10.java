package com.thinking.demo.chapter10;

/**
 * ~~~~
 *
 * @author Alphonse
 * @date 2019/10/30 13:57
 * @since 1.0
 **/
interface I2{
    long f();
}
public class E10 {
    long getI(String ss){
        if(ss.equals("Haha")){
            class Qwe implements I2{
                private String note;
                public Qwe(String note) {
                    this.note = note;
                }
                @Override
                public long f() {
                    return System.currentTimeMillis();
                }
            }
            return new Qwe("null").f();
        }
        return 1L;
    }

    public static void main(String[] args){
        E10 e10 = new E10();
        long i1= e10.getI("Haha");
        System.out.println(i1);
        i1= e10.getI("Aha");
        System.out.println(i1);
    }
}
