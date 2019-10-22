package com.zyf.demo;

import lombok.Data;

import java.util.Optional;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/21 15:52
 * @since 1.0
 **/
@Data
public class OptionalDemo {
    String data;
    BookDetail bookDetail = new BookDetail();

    public static void main(String[] args){
        OptionalDemo optionalDemo = new OptionalDemo();
        optionalDemo.func();
        String ss = Optional.ofNullable(optionalDemo.getData()).orElse("1");
        System.out.println(ss);
    }

    void func(){
        System.out.println(bookDetail.toString());
        Optional<BookDetail> opt = Optional.of(bookDetail);
        opt.get().toString();
        System.out.println(opt.toString());
        data = "da";
    }

}
