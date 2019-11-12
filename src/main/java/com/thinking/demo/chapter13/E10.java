package com.thinking.demo.chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/12 13:55
 * @since 1.0
 **/
public class E10 {
    public static void main(String[] args) {
        String seq = "Java now has regular expression";
        String[] regexs = new String[]{"^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s+", "s{4}", "s{1}", "s{0,3}\\("};
        for (String regex:
             regexs) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(seq);
            while(m.find()) {
                System.out.println("Match \"" + regex + "\" at position " + m.start() + "-" + (m.end()-1));
            }
        }
        String sequ = "Arline ate eight apples and one orange while Anita hadn't any";
        String reg = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        Matcher mm = Pattern.compile(reg).matcher(sequ);
        if(mm.find()) {
            System.out.println("Match \"" + reg + "\" at position " + mm.start() + "-" + (mm.end()));
        }

    }
}

/**
 * ? ：零个或一个
 * * ：零个或多个
 * + ：一个或多个
 * ? ：”非获取匹配，匹配冒号后的内容但不获取匹配结果，不进行存储供以后使用。
 * 单独的“?”：匹配前面的子表达式零次或一次。
 * 当“?”紧跟在任何一个其他限制符（*,+,?，{n}，{n,}，{n,m}）后面时，匹配模式是非贪婪的,勉强性。
 * 非贪婪模式尽可能少地匹配所搜索的字符串，而默认的贪婪模式则尽可能多地匹配所搜索的字符串。
 * 匹配小括号需要用[]包围或者使用转义\。
 * 正则表达式符号表见excel文件。
 */