package com.example.demo.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

// 用于浏览器直接输入http地址 (http://localhost:port/demo/page/...)
// @RequestMapping("/demo/page")是为了和static目录层级一致
@Controller
@RequestMapping("/demo/page")
public class DemoHtmlController {

    // 数据查询测试
    @RequestMapping("/test")
    public ModelAndView helloHtml() {
        System.out.println(2213);

        Map<String,String> map = new HashMap<>();
        map.put("hhh","HHH1HH");
        map.put("ee","HHH1HH");
        //ModelAndView modelAndView  = new ModelAndView("/demo/page/hhh",map);
        ModelAndView modelAndView  = new ModelAndView("/demo/page/hhh.html");
        modelAndView.addObject("hhh","ADDHHH");

        return modelAndView;
    }

    // 上传测试
    @RequestMapping("/upload")
    public ModelAndView uploadHtml() {
        return new ModelAndView("/demo/page/upload.html");
    }
}
