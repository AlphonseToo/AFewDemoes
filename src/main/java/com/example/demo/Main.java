package com.example.demo;

import com.example.demo.condiitionalOnMissingBean.bean.Computer;
import com.example.demo.conditionDemo.bean.User1;
import com.example.demo.conditionalOnClass.bean.AClass;
import com.example.demo.conditionalOnClass.bean.BClass;
import com.example.demo.spring.Boot;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 主控制类
 *
 * @author Alphonse
 * @date 2019/10/14 11:19
 * @since 1.0
 **/
@Data
@AllArgsConstructor
public class Main {
    private Boot boot;
    private User1 user1;
    private AClass aClass;
    private BClass bClass;
    private Computer computer;

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.toString());

    }

    public Main() {
        init();
    }

    private void init() {
        this.boot = new Boot();
        this.user1 = new User1();
        this.aClass = new AClass();
        this.bClass = new BClass();
        this.computer = new Computer();
    }

    @Override
    public String toString() {
        return "Main{\n" +
                "\tboot=" + boot +
                ",\n\tuser1=" + user1 +
                ",\n\taClass=" + aClass.gg() +
                ",\n\tbClass=" + bClass.gg() +
                ",\n\tcomputer=" + computer +
                "\n}";
    }
}
