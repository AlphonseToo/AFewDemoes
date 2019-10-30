package com.thinking.demo.chapter10;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/30 13:50
 * @since 1.0
 **/
interface I1{
    long f();
}

/**
 * 内部类不允许有static域
 */
public class E9 {
    I1 getI(String ss){
        class Qwe implements I1{
            private String note;
            int i = 0;
            public Qwe(String note) {
                this.note = note;
            }

            @Override
            public long f() {
                return System.currentTimeMillis();
            }
        }
        return new Qwe(ss);
    }

    public static void main(String[] args){
        E9 e9 = new E9();
        I1 i1= e9.getI("Haha");
        System.out.println(i1.f());
    }
}
