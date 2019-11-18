package com.thinking.demo.chapter14;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/15 14:20
 * @since 1.0
 **/

interface Instrument {
    void play();
    String what();
    void adjust();
    void prepareInstrument();
}
class Wind implements Instrument {
    @Override
    public void play() {
        System.out.println("Wind.play()");
    }

    @Override
    public String what() {
        return "Wind";
    }

    @Override
    public void adjust() {}
    public void clearSpitValve() {
        System.out.println("Wind.clearSpitValve");
    }
    @Override
    public void prepareInstrument() {
        clearSpitValve();
    }
}
public class E26 {
    public static void main(String[] args) {
        String result = "";
        for(int i = 0; i < args.length; i++) {
            result += args[i];
        }
        System.out.println(result);
    }
}
