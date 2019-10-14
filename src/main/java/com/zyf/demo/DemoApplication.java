package com.zyf.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.JButton;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@SpringBootApplication
@RequestMapping(value = "/main")
public class DemoApplication {

    @RequestMapping("/a")
    public String index() {
        return "hello spring boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        new Thread(() -> System.out.println("here!")).start();
        JButton show = new JButton("Show");
        show.addActionListener(e -> e.getActionCommand());
        show.addActionListener(e -> System.out.println("Listener."));

        List<String> features = Arrays.asList("1", "22", "33", "4");
        features.forEach(a -> System.out.println(a+a));

        List<Integer> list = Arrays.asList(100, 200, 300, 400, 500);
        double bill = list.stream().map(cost -> cost+cost*.12).reduce((sum, cost) -> sum + cost).get();
        System.out.println("bill: " + bill);

        List<String> filter = features.stream().filter(x -> x.length() > 1).collect(Collectors.toList());
        System.out.printf("ssss: %s %n1", filter);
    }

}
