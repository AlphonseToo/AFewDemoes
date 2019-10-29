package com.thinking.demo.chapter8;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/24 17:40
 * @since 1.0
 **/

public class Instrument {
    public void play(){}
    static void tune(Instrument i){
        //...
        i.play();
    }
}
class Stringed extends Instrument{
    public void play(){
        System.out.println("Stringed");
    }
}
class Brass extends Instrument{
    public void play(){
        System.out.println("Brass");
    }
}
class Wind extends Instrument{
    public void play(){
        System.out.println("Wind");
    }
}
class Music2{
    public static void tune(Wind i){
        i.play();
    }
    public static void tune(Stringed i){
        i.play();
    }
    public static void tune(Brass i){
        i.play();
    }
    public static void tune(Instrument i){
        i.play();
    }
    public static void main(String[] args){
        Wind flute = new Wind();
        Stringed violin = new Stringed();
        Brass french = new Brass();
        tune(flute);
        tune(violin);
        tune(french);
    }
}