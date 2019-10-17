package com.thinking.demo.chapter5;

public class Output extends House{
    House h1 = new House();

    Output(){
        System.out.println("Output");
        h2 = new House();
    }

    House h2 = new House();

    protected void finalize(){
        System.out.println("Output cleanup!");
    }

    public static void main(String[] args) {
        Output out = new Output();
        out.f();
    }
}
