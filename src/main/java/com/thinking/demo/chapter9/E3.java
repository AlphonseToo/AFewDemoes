package com.thinking.demo.chapter9;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/28 17:07
 * @since 1.0
 **/

interface Cycle{
    void ride();
}
interface CycleFactory{
    Cycle getCycle();
}
class Unicycle implements Cycle{
    @Override
    public void ride() {
        System.out.println("单轮车骑行。");
    }
    public static CycleFactory factory = () -> new Unicycle();
}
class Bicycle implements Cycle{
    @Override
    public void ride() {
        System.out.println("自行车骑行。");
    }
    public static CycleFactory factory = () -> new Bicycle();
}
class Tricycle implements Cycle{
    @Override
    public void ride() {
        System.out.println("三轮车骑行。");
    }
    public static CycleFactory factory = () -> new Tricycle();
}
class UnicycleFactory implements CycleFactory{
    public Cycle getCycle(){
        return new Unicycle();
    }
}
class BicycleFactory implements CycleFactory{
    public Cycle getCycle(){
        return new Bicycle();
    }
}
class TricycleFactory implements CycleFactory{
    public Cycle getCycle(){
        return new Tricycle();
    }
}
public class E3 {
    public static void move(Cycle cycle){
        cycle.ride();
    }
    public static void cycleConsumer(CycleFactory fact){
        Cycle c = fact.getCycle();
        c.ride();
    }

    public static void main(String[] args){
        cycleConsumer(new UnicycleFactory());
        cycleConsumer(new BicycleFactory());
        cycleConsumer(new TricycleFactory());
        cycleConsumer(Unicycle.factory);
        cycleConsumer(Bicycle.factory);
        cycleConsumer(Tricycle.factory);
        move(new Unicycle());
        move(new Bicycle());
        move(new Tricycle());
    }
}
