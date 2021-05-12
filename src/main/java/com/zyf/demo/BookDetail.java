package com.zyf.demo;

import com.zyf.demo.mypackage.Pck1;
import lombok.Data;

/**
 * @ClassName: BookDetial
 * @Description: BookDetial
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/9/25 14:47
 **/

@Data
public class BookDetail {
    private int no = 1;
    private String name = "Store";
    private String author = "z";
    private String introduction = "......";

    @Override
    public String toString() {
        return "BookDetail{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Pck1.main(new String[]{"a"});
    }
}
