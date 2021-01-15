package com.thinking.demo.chapter14;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/13 16:11
 * @since 1.0
 **/
class Initable {
    static final int num = 4;
    static final int variable = new Random(55).nextInt();
    static int staNum = 7;
    static {
        System.out.println("Initialize Initable");
    }
}
class Initable2 {
    static int nonFinal = 7777;
    static {
        System.out.println("Initialize Initable2");
    }
    static int aRandomNum = ff();

    static int ff(){
        System.out.println("Here 2019");
        return 2019;
    }
}
class Initable3 {
    static int nonFinal = 89;
    static {
        System.out.println("Initialize Initable3");
    }
}

/**
 * 使用.class语法来获得对类的引用不会引发初始化；
 * 但是使用Class.forName()就会立即进行初始化；
 * 如果一个static final值是编译器常量，则这个值不需要对所属的类进行初始化就可以读取；但是如果只是将一个域设置为static和final的，则必须强制进行类的初始化。
 * 如果仅仅是static，则在访问该域的时候也会执行它所在类的初始化，即会执行其他模块的static代码或者数据域初始化（分配空间并初始化该存储空间）。
 * 此处static的执行顺序还是按照声明顺序来执行的，乍一看，好像是先执行的static代码块，实际上还是先初始化的varibale，后执行的静态代码块，只不过是最后打印的而已；
 * ? - 通配符 - 表示任何类型，可以和关键字extends联用。
 * a instanceof B  x 是否是 B 的实例对象？ a还可以是B的子类的对象
 *  B.isInstance(a)和instanceof功能一样
 */
public class T1 {
    public static void main(String[] args) {
        Class initable = Initable.class;
        Initable ii = new Initable();
        System.out.println("*****************");
        System.out.println(Initable.num);
        System.out.println(Initable.variable);
        System.out.println(Initable.staNum);
        System.out.println("*****************");
        System.out.println(Initable2.nonFinal);

        Pattern p = Pattern.compile("\\w+\\.");

    }
}
