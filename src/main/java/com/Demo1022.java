package com;

import cn.hutool.core.util.StrUtil;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1022 {
    public static void main(String[] args) {
        System.out.println(getFileEncode("C:\\Users\\Mine\\Desktop\\subtrans.sql"));
        System.out.println(getFileEncode("C:\\Users\\Mine\\Desktop\\a03i001.sql"));
        List<String> asd = new ArrayList<>();
        String ss = StrUtil.join(",", asd);
        System.out.println(ss.equals(""));
    }

    private static String getFileEncode(String filePath) {
        File file = new File(filePath);
        String sqlChartSet = "";
        try {
            InputStream in = new java.io.FileInputStream(file);
            byte[] bytes = new byte[5];
            in.read(bytes);
            sqlChartSet = getChineseEncodingByBytes(bytes);
        } catch (Exception e) {
            System.out.println("获取文件编码异常");
        }
        return sqlChartSet;
    }

    public static String getChineseEncodingByBytes(byte[] buff){
        String[] AVAILABLE_CHINESE_CHARSET_NAMES = new String[] { "GBK", "gb2312", "GB18030", "UTF-8", "Big5" };
        Pattern CHINESE_COMMON_CHARACTER_PATTERN = Pattern.compile("的|一|是|了|我|不|人|在|他|有|这|个|上|们|来|到|时|大|地|为|子|中|你|说|生|国|年|着|就|那|和|要|下|自|成|附|工|看|情|详|步|审|等|吧|吗|只|能");

        String encoding="unknown";
        //utf_bom 检测
        if(buff.length>3){
            if(buff[0]==-1&&buff[1]==-2){
                encoding="UTF-16";
            }
            if(buff[0]==-2&&buff[1]==-1){
                encoding="Unicode";
            }
            if(buff[0]==-17&&buff[1]==-69&&buff[2]==-65){
                encoding="UTF-8";
            }
        }
        if("unknown".equals(encoding)){
            int longestMatch = 0;
            //常用汉字匹配检测
            for (String cs : AVAILABLE_CHINESE_CHARSET_NAMES) {
                String temp = new String(buff, Charset.forName(cs));
                Matcher matcher = CHINESE_COMMON_CHARACTER_PATTERN.matcher(temp);
                int count = 0;
                while (matcher.find()) {
                    count += 1;
                }
                if (count > longestMatch) {
                    longestMatch = count;
                    encoding = cs;
                    break;
                }
            }
        }
        return  encoding;
    }
}
