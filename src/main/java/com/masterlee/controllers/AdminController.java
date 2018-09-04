package com.masterlee.controllers;

import com.masterlee.entity.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class AdminController {
    @RequestMapping(value = "/test",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String test(){
        return "helloworld";
    }
}
