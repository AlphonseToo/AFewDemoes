package com.thinking.demo.chapter19;

/**
 * 自动售货机实现
 *
 * @author Alphonse
 * @date 2019/11/28 11:46
 * @since 1.0
 **/

enum Input{

}
class VendingMachine {
    private static State state;

    enum StateDuration{ TRANSIENT }
    enum State {
        RESTING {
            void next(Input input){}

        }
    }
}
public class E10 {

}
