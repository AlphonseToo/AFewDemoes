package com.thinking.demo.chapter13;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/12 08:51
 * @since 1.0
 **/
public class Hex {
    public static String format(byte[] data) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for(byte b : data) {
            if(n % 16 == 0)
                sb.append(String.format("%05X: ", n));
            sb.append(String.format("%02X ", b));
            n++;
            if(n % 16 == 0)
                sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            //System.out.println(format(BinaryFile.read("Hex.class")));
        } else {
            //System.out.println(BinaryFile.read(new File(args[0])));
        }
    }
}
