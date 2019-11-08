package com.thinking.demo.chapter12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/4 10:37
 * @since 1.0
 **/
class MyException extends Exception{
    private static Logger logger = Logger.getLogger("MyException");

    public MyException(String message) {
        super(message);
    }

    public static void printLog(Exception e){
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        logger.severe(sw.toString());
        logger.warning(sw.toString());
    }
}
public class P1 {
    public static void main(String[] args) {
        try {
            int[] array = new int[]{1,2};
            System.out.println(array[2]);
            System.out.println("try block");
            throw new Exception("exception");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(System.out);
            MyException.printLog(e);
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
