package com.zyf.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: HelloC
 * @Description: TODO
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/9/24 17:52
 **/
@RestController
@RequestMapping(value = "/hello")
public class HelloC {
    @Value("${cpuSize}")
    private String cpusize;
    @Value("${age}")
    private String age;
    @Value("${context}")
    private String context;

    @Autowired
    private FantasticGuy fantasticGuy;
    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String say() {
        //return cpusize + "here" + age;
        return context + " " + fantasticGuy.toString();
    }

    @RequestMapping(value = "/say/{idnum:[1-9]+}-{alph:[a-z]*}", method = RequestMethod.GET)
    public String say2(@PathVariable String idnum, @PathVariable String alph) {
        return "输入的是: " + idnum;
    }

    @RequestMapping(value = "/on/{idnum:one|two}")
    public String say2b(@PathVariable String idnum) {
        return "输入的是: " + idnum;
    }

    @RequestMapping(name = "ss", value = "/talk", method = RequestMethod.GET, params = {"id!=[a-z]*", "!op"})
    public String sayparam(@RequestParam(value = "id", required = true, defaultValue = "sdasda") String id,
                           @RequestParam(value = "op", required = true, defaultValue = "489") String name) {
        return "输入的是1: " + id + " " + name;
    }

    @RequestMapping(value = "/prod", produces = {"application/JSON"})
    public String gen() {
        return "gen Product";
    }

    @RequestMapping(value = "/cons", consumes = {"text/*"})
    public String consume() {
        return "gen Consume";
    }

    @RequestMapping(value = "/header", headers = {"text/"})
    public String header() {
        return "gen Header";
    }

    @RequestMapping(value = "/book")
    public String book(@RequestBody BookDetail book) {
        return book.toString();
    }

    @RequestMapping(value = "/bookList")
    public List<BookDetail> bookList(@RequestBody List<BookDetail> book) {
        return book;
    }
}
