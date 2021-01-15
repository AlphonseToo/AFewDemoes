package com.thinking.demo.chapter18;

import com.thinking.demo.ConstConfig;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/27 11:30
 * @since 1.0
 **/

class Blip3 implements Externalizable {
    private int i;
    private String s;
    public Blip3() {
        System.out.println("Blip3 Constructor");
    }
    public Blip3(int i, String s) {
        System.out.println("Blip3(String x, int a)");
        this.i = i;
        this.s = s;
    }
    public String toString() {
        return s + i;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        /**
         * You must do this 保存该对象的时候会用到这个方法,但不是必须的—，若没有实现这个方法，则保存对象信息时只是保存了该对象类型，里面的数据没有保存，
         * 所以在后面读取该对象的时候，读取不到该对象的数据域，如果使用in.readXXX()，则会报错，因为文件中并没有数据域
         */
        out.writeObject(s);
        out.writeInt(i);
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        // You must do this
        s = (String)in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        String path = "C:\\Users\\DELL\\Desktop\\zz\\";
        System.out.println("Constructing objects: ");
        Blip3 b3 = new Blip3(47, "A String");
        System.out.println(b3);

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(path + "Blip3.out"));
        System.out.println("Saving object: ");
        o.writeObject(b3);
        o.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path + "Blip3.out"));
        System.out.println("Recovering b3:");
        b3 = (Blip3)in.readObject();
        System.out.println(b3);
    }
}

/**
 * transient关键字使该数据不会在序列化时自动保存和恢复；
 * 在采用Externalizable(继承自Serializable）序列化的时候，需要自己来实现writeExternal和readExternal方法，这两个方法分别会在序列化保存到文件中和从文件中恢复时用到；实现该接口的类一定要有无参构造函数
 * 在采用Serializable序列化的时候，会自动将非transient修饰的属性序列化到指定的文件中去，无须重写任何方法。你可以手动添加writeExternal和readExternal方法，来自己定义序列化的内容；采用反射机制来实现
 */
public class E28 implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    public E28(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "E28{" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception {
        E28 a = new E28("Hulk", "myLittlePony");
        System.out.println("E28 a = " + a);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(ConstConfig.path + "Logon.out"));
        o.writeObject(a);
        o.close();

        TimeUnit.SECONDS.sleep(2);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(ConstConfig.path + "Logon.out"));
        System.out.println("Recovering Object at " + new Date());
        a = (E28)in.readObject();
        System.out.println("logon a = " + a);

    }
}
