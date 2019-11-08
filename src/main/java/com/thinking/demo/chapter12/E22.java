package com.thinking.demo.chapter12;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/7 17:44
 * @since 1.0
 **/
public class E22 {
    private int i;
    public E22(int i) throws Exception {
        if(i < 0)
            throw new Exception("i不能小于0");
        System.out.println(this.i=i);
    }
    void dispose() throws Exception{
        if(i == 0)
            throw new Exception("清理失败");
        i = 0;
        System.out.println("清理完毕");
    }
    public static void main(String[] args) {
        try{
            E22 e22 = new E22(0);
            try{
                E22 e221 = new E22(0);
                try{
                    e221.dispose();
                }catch (Exception e){
                    System.out.println("e221:" + e);
                }
            }catch (Exception e) {
                System.out.println(e);
            }finally {
                try {
                    e22.dispose();
                }catch (Exception e){ //清理失败
                    System.out.println("e22" + e);
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
