package com.thinking.demo.chapter12;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/7 15:46
 * @since 1.0
 **/

class ImportantException extends Exception {
    @Override
    public String toString() {
        return "ImportantException{}";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "HoHumException{}";
    }
}

public class E19 {
    void f() throws ImportantException {
        throw new ImportantException();
    }
    void g() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try{
            E19 e19 = new E19();
            try{
                e19.f();
            }catch (Exception e) {
                System.out.println(e);
            }finally {
                e19.g();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
