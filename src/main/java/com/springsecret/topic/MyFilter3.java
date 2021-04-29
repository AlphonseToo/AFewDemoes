package com.springsecret.topic;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * MyFilter3
 *
 * @author Alphonse
 * @version 1.0
 **/
@Component
public class MyFilter3 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter3");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
