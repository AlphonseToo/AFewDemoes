package com.thinking.demo.chapter10.p3;

import com.thinking.demo.chapter10.p1.Inter;
import com.thinking.demo.chapter10.p2.Xdd;

/**
 * ~~~
 *
 * @author Alphonse
 * @date 2019/10/29 15:55
 * @since 1.0
 **/
public class Fio extends Xdd {
    public Inter getCdd(){
        pp();
        return this.new Cdd();
    }

    public static void main(String[] args){
        Fio fio = new Fio();
        fio.getCdd();
        Cdd cdd = fio.new Cdd();
        cdd.f();
    }
}

class Test{
    public static void main(String[] args){
        Fio fio = new Fio();
        fio.getCdd();
    }
}
