package com.thinking.demo.chapter14;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/13 15:38
 * @since 1.0
 **/
public class Common {
    public static final String PACKAGE = "com.thinking.demo.chapter14.";
}

/**
 * 使用.class语法来获得对类的引用不会引发初始化；
 * 但是使用Class.forName()就会立即进行初始化；
 * 如果一个static final值是编译器常量，则这个值不需要对所属的类进行初始化就可以读取；但是如果只是将一个域设置为static和final的，则必须强制进行类的初始化。
 * 如果仅仅是static，则在访问该域的时候也会执行初始化，即会执行其他模块的static代码或者数据域初始化（分配空间并初始化该存储空间）。
 * 此处static的执行顺序还是按照声明顺序来执行的，乍一看，好像是先执行的static代码块，实际上还是先初始化的varibale，后执行的静态代码块，只不过是最后打印的而已；
 * 当调用static但不是final时，则同时对该类的其他的静态模块进行初始化；
 * ? - 通配符 - 表示任何类型，可以和关键字extends联用。
 * a instanceof B  x 是否是 B 的实例对象？ a还可以是B的子类的对象
 *  B.isInstance(a)和instanceof功能一样
 */

/**
 * 反射：一般的RTTI是在编译时确定对象类型的，包括向上转型等；反射是指在程序运行时才知道某一对象的类型信息。
 */