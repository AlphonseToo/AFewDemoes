package com.zyf.demo;

import lombok.Data;

/**
 * @ClassName: BookDetial
 * @Description: TODO
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/9/25 14:47
 **/

@Data
public class BookDetail {
    private int no;
    private String name;
    private String author;
    private String introduction;

    /*@Override
    public String toString() {
        return "BookDetial{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }*/
}
