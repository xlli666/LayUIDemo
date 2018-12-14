package com.example.demo.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DemoThController {
    @RequestMapping("hello")
    public String sayHello(Model model){
        model.addAttribute("hhh","HHH");
        return "hello";
    }
}
