package com.thinking.demo.chapter7.Proxy;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/25 14:03
 * @since 1.0
 **/

class Car{
    void drive(){}
    void park(){}
}
class MyCar extends Car{
    private String name;

    public MyCar(String name) {
        this.name = name;
    }
}
public class DriveProxy {
    private Car car;

    public DriveProxy(Car car) {
        this.car = car;
    }

    void drive(){
        //do something extra
        car.drive();
    }
    void park(){
        //do something extra
        car.park();
    }
    public static void main(String[] args){
        MyCar myCar = new MyCar("Audi");
        DriveProxy proxy = new DriveProxy(myCar);
        proxy.drive();
        proxy.park();
    }
}
class DriveCar{
    public static void main(String[] args){
        MyCar myCar = new MyCar("Audi");
        DriveProxy proxy = new DriveProxy(myCar);
        proxy.drive();
        proxy.park();
        final String s1 = "s1";
        String s2 = "s2";
        s1.replace("s", "98");
        System.out.println(s1);
        //s1 = s2;
    }
}

class A{
    int i;

    public A(int i) {
        this.i = i;
    }
    public static void main(String[] args){
        final A s1 = new A(1);
        A s2 = new A(2);
        s1.i = 11;
    }
}

