package com.zyf.demo;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * ~~~~~~~
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
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        String dateString = "2019-01-31";
        date = LocalDate.parse(dateString, df);
        //System.out.println(date.getDayOfWeek().toString());
        System.out.println(date.toString());
        System.out.println(date.plusDays(-23).toString());

    }

    void func(){
        System.out.println(bookDetail.toString());
        Optional<BookDetail> opt = Optional.of(bookDetail);
        opt.get().toString();
        System.out.println(opt.toString());
        //data = "da";
    }

}
