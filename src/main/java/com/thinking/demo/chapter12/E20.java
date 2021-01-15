package com.thinking.demo.chapter12;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/7 16:30
 * @since 1.0
 **/

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}
abstract class Inning {
    public Inning() throws BaseballException {
        System.out.println("here");
        throw new BaseballException();
    }
    public Inning(String s) throws RainedOut {
        System.out.println("here: " + s);
        throw new RainedOut();
    }
    public abstract void event() throws Foul;
    public abstract void atBat() throws Strike, Foul;
    public void walk() {}
}
class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}
class PushFoul extends PopFoul {}
interface Storm {
    public void event() throws PopFoul;
    public void rainHard() throws RainedOut;
}
interface Wind {
    public void event() throws PushFoul;
}
/**
 *
 * 基类或者接口中的方法未抛出异常的，子类中也不能抛出任何异常；
 * 基类或者接口中的方法抛出异常,子类对应的方法可以不抛出任何异常，若抛出异常，则必须是基类中抛出的异常的子类，或者就是它本身；这一点在implements的接口中也适用；
 * 如果一个类既继承了类又implements了某个接口，且它们都有相同方法签名(此处还包括抛出的异常是同一条异常类继承链上的)的方法，那么覆写该方法是ok的，抛出的异常是基类或者接口中继承链最长的异常类本身或者其子类。
 * 子类的构造器抛出的异常A要包含用到的基类的构造器所抛出的异常B（此处包含的意思是：A可以和B相同，或者A是B的父类，但A不能是B的子类，这刚好和方法异常的继承相反）,当然你可以额外抛出自己想要抛出的异常。
 * 异常抛出的匹配机制是就近原则，派生类的对象也可以匹配其基类的处理程序,下面的程序是合法的：
 * try{
 *     throw new PopFoul();
 * }catch(Foul e){
 *     //do something
 * }catch(PopFoul e) {
 *     //执行不到这里，idea编译器会报错
 * }
 */
public class E20 extends Inning implements Storm {
    public E20() throws Exception {}
    public E20(String s) throws Foul, RainedOut {super(s);}
    @Override
    public void event() throws PushFoul {}
    @Override
    public void rainHard() throws RainedOut {}
    @Override
    public void atBat() throws PopFoul {}

    public static void main(String[] args) {
        try{
            E20 e20 = new E20();
        }catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }finally {

        }
    }
}
