package com.thinking.demo.chapter12;

/**
 * TODO
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
    public void event() throws BaseballException {}
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
 * 子类中抛出的异常必须是基类或者继承的接口异常类(并集）的子类；
 * 基类或者接口中的方法未抛出异常的，子类中也不能抛出任何异常；
 * 基类或者接口中的方法抛出异常,子类对应的方法可以不抛出任何异常；
 * 子类的构造器抛出的异常A要包含用到的基类的构造器所抛出的异常B（A可以和B相同，或者A是B的基类，但A不能是B的子类，这刚好和方法异常的继承相反）
 * 异常抛出的匹配机制是就近原则，派生类的对象也可以匹配其基类的处理程序,下面的程序是合法的：
 * try{
 *     throw new PopFoul();
 * }catch(Foul e){
 *     //do something
 * }
 */
public class E20 extends Inning implements Storm {
    public E20() throws Exception {}
    public E20(String s) throws Foul, RainedOut {super(s);}
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
        }
    }
}
