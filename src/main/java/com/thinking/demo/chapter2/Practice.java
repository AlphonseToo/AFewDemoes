package com.thinking.demo.chapter2;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * ~~~~
 *
 * @author Alphonse
 * @date 2019/10/14 15:28
 * @since 1.0
 **/
//@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan
//以下四个都可被注册为bean
@Component
@Service
@Repository
@Controller
@ConfigurationProperties(prefix = "connection")
@EnableConfigurationProperties
@Import(Dog.class)
public class Practice {
    @Autowired
    @Getter
    private Dog dog;
    private double s, t, v, u;
    private int a, b;
    private static Random random = new Random();
    public static void main(String [] args) {
        Practice practice = new Practice();
        //Practice practice1 = new Practice();
        System.out.println(practice.toString());
        //System.out.println(practice1.toString());
        //System.out.println(practice.equals(practice1));
        String coin = practice.a == 1 ? "tail" : "head";
        System.out.println("coin: " + coin + "    a：" + practice.a + " b: " + practice.b);
        practice.loop1();
        practice.getDog().bark(4, true);
    }

    public Practice() {
        init();
    }

    @Override
    public boolean equals(Object obj) {
        return this.v == ((Practice)obj).v;
    }

    private void init() {
        s = random.nextDouble();
        t = random.nextDouble();
        v = s/t;
        a = random.nextInt(2);
        b = 0xff;
        u = 1e-5;
        for (int i = 0; i < 8; i++) {
            System.out.println(Integer.toBinaryString(b=b>>>1));
        }

    }

    private void loop(int f) {
        int[] array = new int[100+1];
        for (int i = 1; i <= f; i++) {
            if (i == 1 || i == 2) {
                System.out.print(" "+ (array[i] = 1));
            }
            else
                System.out.print(" " + (array[i] = array[i-1]+array[i-2]));
        }
    }

    private void loop1() {
        for (int i = 11; i < 100; i++) {
            for (int j = i; j > 10; j--) {
                if(i*j < 1000)
                    break;
                if(i%10 == 0 && j %10 == 0)
                    continue;
                isNum(i, j);
            }
        }
    }

    private void isNum(int i, int j) {
        int k = i*j;
        char[] kk = Integer.toString(k).toCharArray();
        char[] ii = Integer.toString(i).toCharArray();
        char[] jj = Integer.toString(j).toCharArray();
        int match = 0;
        for (char c: kk) {
            if(c == ii[0]){
                match++;
                ii[0] = 'a';
                continue;
            }
            if(c == ii[1]){
                match++;
                ii[1] = 'b';
                continue;
            }
            if(c == jj[0]){
                match++;
                jj[0] = 'x';
                continue;
            }
            if(c == jj[1]){
                match++;
                jj[1] = 'y';
                continue;
            }
        }
        if (match == 4) {
            System.out.println("" + k + "=" + i + "*" + j);
        }
    }
    //无用的注释
    //无用的注释。
    //无用的注释。。
    //无用的注释。。。
    @Override
    public String toString() {
        return "Practice{" +
                "s=" + s +
                ", t=" + t +
                ", v=" + v +
                '}';
    }
    //2^32+a
}
