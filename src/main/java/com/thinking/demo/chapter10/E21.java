package com.thinking.demo.chapter10;

/**
 * ~~~~
 *
 * @author Alphonse
 * @date 2019/10/30 15:49
 * @since 1.0
 **/

/**
 * 普通内部类不允许有static数据和字段
 * 嵌套类是受static关键字限制的内部类，允许有static数据和字段。
 * 内部类变相的实现了C++中的类的多重继承的功能，每个内部类对应一个继承类。:)
 */
interface I21_1{
    int f();
    class C21_1{
        public int i = 7;
        public static I21_1 getI21(){
            class C21_2 implements I21_1{
                @Override
                public int f() {
                    return 78;
                }
            }
            return new C21_2();
        }
    }
    static void main(String[] args){
        C21_1.getI21();
        C21_1 c21_1 = new C21_1();
        c21_1.i = 0;
    }
}
public class E21 {
}
