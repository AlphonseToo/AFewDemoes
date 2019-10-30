package com.thinking.demo.chapter9;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * ~~~~
 *
 * @author Alphonse
 * @date 2019/10/28 17:19
 * @since 1.0
 **/

interface Game{
    void play();
    void play(int i);
}
interface GameService{
    Game getGame();
}
class Flip implements Game{
    @Override
    public void play() {
        long t = System.currentTimeMillis();
        Random random = new Random(t);
        String out = random.nextInt(10) % 2 == 0 ? "head":"tail";
        System.out.print(out+" ");
    }

    @Override
    public void play(int i) {
        System.out.print("Flip: {");
        for (int j = 0; j < i; j++) {
            try {
                sleep(2);
            } catch (InterruptedException e) { }
            play();
        }
        System.out.println("}");
    }
}
class Coin implements Game{
    @Override
    public void play() {
        long t = System.currentTimeMillis();
        Random random = new Random(t);
        int out = (random.nextInt(100) % 6) + 1;
        System.out.print(out+" ");
    }
    public void play(int i){
        System.out.print("Coin: {");
        for (int j = 0; j < i; j++) {
            try {
                sleep(9);
            } catch (InterruptedException e) {
            }
            play();
        }
        System.out.println("}");
    }
}
class FlipGameFactory implements GameService{
    @Override
    public Game getGame() {
        return new Flip();
    }
}
class CoinGameFactory implements GameService{
    @Override
    public Game getGame() {
        return new Coin();
    }
}

public class E4 {
    public static void gameConsumer(GameService fact, int times){
        Game c = fact.getGame();
        c.play(times);
    }
    public static void main(String[] args){
        gameConsumer(new FlipGameFactory(), 5);
        gameConsumer(new CoinGameFactory(), 10);
    }
}
