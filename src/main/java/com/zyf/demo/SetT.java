package com.zyf.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * ****
 *
 * @author Alphonse
 * @date 2020/4/20 16:26
 * @since 1.0
 **/
public class SetT {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        List<String> stringList = Arrays.asList();
        for (int i = 0; i < stringList.size(); i++) {
            if (!hashSet.add(stringList.get(i))) {
                System.out.println(String.format("第%d个子协议校验失败：签约账号与前面已有的重复。", i+1));
            }
        }
        System.out.println(new Date().toString());
    }
}
