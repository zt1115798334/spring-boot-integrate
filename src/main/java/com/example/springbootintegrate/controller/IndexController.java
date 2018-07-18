package com.example.springbootintegrate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/7/18 14:17
 * description:
 */
@Controller
public class IndexController {

    @GetMapping("login")
    public String login() {
        System.out.println("true = " + true);
        return "loginV";
    }
}
