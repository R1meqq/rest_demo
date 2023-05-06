package com.example.rest_demo.exeption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SpringShipException.class)
    public String servletRequestBindingException(ServletRequestBindingException e) {
        log.error("SpringBlogException occurred: " + e.getMessage());
        return "error";
    }

}