package com.example.demo.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/demo/page")
public class DemoHtmlController {
    @RequestMapping("/test")
    public ModelAndView helloHtml() {
        Map<String,String> map = new HashMap<>();
        System.out.println(2213);
        map.put("hhh","HHH1HH");
        map.put("ee","HHH1HH");
        //ModelAndView modelAndView  = new ModelAndView("/demo/page/hhh",map);

        ModelAndView modelAndView  = new ModelAndView("/demo/page/hhh");
        modelAndView.addObject("hhh","ADDHHH");
        return modelAndView;
    }

    @RequestMapping("/upload")
    public ModelAndView uploadHtml() {
        return new ModelAndView("/demo/page/upload");
    }

    @RequestMapping("/index")
    public ModelAndView dashboardHtml() {
        return new ModelAndView("/demo/page/index");
    }
}
