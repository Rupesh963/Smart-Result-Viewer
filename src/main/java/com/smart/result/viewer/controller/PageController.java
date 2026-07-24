package com.smart.result.viewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String index(){
        return "Index";
    }

    @GetMapping("/view-result")
    public String viewResult(){
        return "view result";
    }
}
