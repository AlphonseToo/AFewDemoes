package com.thinking.demo.chapter9;

/**
 * ~~~~~
 *
 * @author Alphonse
 * @date 2019/10/29 10:20
 * @since 1.0
 **/

interface Processor{
    String name();
    Object process(Object input);
}
class C60{
    public String name(){
        return getClass().getSimpleName();
    }
    public String reverse(String s){
        return s;
    }
}
class C61 extends C60{
    @Override
    public String reverse(String s){
        return s.toUpperCase();
    }
}
class Adapter implements Processor{
    C61 c61;
    public Adapter(C61 c61) {
        this.c61 = c61;
    }
    @Override
    public String name() {
        return c61.name();
    }
    @Override
    public String process(Object input) {
        return c61.reverse((String)input);
    }
}
class Apply {
    public static void process(Processor p, Object s){
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}
public class E6 {
    public static void main(String[] args){
        Apply.process(new Adapter(new C61()), "i am a a a a");
    }
}
