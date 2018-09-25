package com.myelastic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zhanglu on 2018/9/21.
 */
@Controller
public class PageController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
