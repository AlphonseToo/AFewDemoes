package com.spring.in.action.chapter05.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2020/1/7 15:16
 * @since 1.0
 **/
@Controller
@RequestMapping({"/", "homepage"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
