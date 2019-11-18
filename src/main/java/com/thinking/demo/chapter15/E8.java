package com.thinking.demo.chapter15;

import java.util.Random;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/18 16:16
 * @since 1.0
 **/
interface StoryCharacters{
    String name();
    String dance();
    boolean side();
}

class Wu implements StoryCharacters{
    @Override
    public String name() {
        return "吴--";
    }
    @Override
    public String dance() {
        return "Wu is dancing";
    }
    @Override
    public boolean side() {
        return true;
    }
}
class Hu implements StoryCharacters{
    @Override
    public String name() {
        return "胡++";
    }
    @Override
    public String dance() {
        return "Hu is dancing";
    }
    @Override
    public boolean side() {
        return true;
    }
}
class Liu implements StoryCharacters{
    @Override
    public String name() {
        return "刘--";
    }
    @Override
    public String dance() {
        return "Liu is dancing";
    }
    @Override
    public boolean side() {
        return false;
    }
}
class Ma implements StoryCharacters{
    @Override
    public String name() {
        return "马++";
    }
    @Override
    public String dance() {
        return "Ma is dancing";
    }
    @Override
    public boolean side() {
        return false;
    }
}
class CharactersGen{
    private Class[] set = new Class[]{Wu.class, Hu.class, Liu.class, Ma.class};
    private Class[] goodSet = new Class[]{Wu.class, Hu.class};
    private Class[] badSet = new Class[]{Liu.class, Ma.class};
    private Random random = new Random(47);
    public StoryCharacters genAll(){
        return gen(0);
    }
    public StoryCharacters genGood(){
        return gen(1);
    }
    public StoryCharacters genBad(){
        return gen(2);
    }
    private StoryCharacters gen(int i){
        try {
            if(i == 0) return (StoryCharacters)set[random.nextInt(set.length)].newInstance();
            if(i == 1) return (StoryCharacters)goodSet[random.nextInt(goodSet.length)].newInstance();
            if(i == 2) return (StoryCharacters)badSet[random.nextInt(badSet.length)].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
public class E8 {
    public static void main(String[] args) {
        CharactersGen cg = new CharactersGen();
        for (int i = 0; i < 5; i++) {
            System.out.println(cg.genAll().dance());
        }
    }
}
