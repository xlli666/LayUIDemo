package com.example.demo.controller.back;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @RequestMapping("/query")
    @ResponseBody
    public Object menuQuery(){
        //三级导航
        JSONObject jsonObjLvl31 = new JSONObject();
        jsonObjLvl31.put("title","三级导航");
        jsonObjLvl31.put("icon","");
        jsonObjLvl31.put("href","hhh.html");
        //三级导航
        JSONObject jsonObjLvl32 = new JSONObject();
        jsonObjLvl32.put("title","三级导航");
        jsonObjLvl32.put("icon","");
        jsonObjLvl32.put("href","buttwswon.html");
        JSONArray jsonArrL3 = new JSONArray();
        jsonArrL3.add(jsonObjLvl31);
        jsonArrL3.add(jsonObjLvl32);

        //二级导航
        JSONObject jsonObjLvl2 = new JSONObject();
        jsonObjLvl2.put("title","二级导航");
        jsonObjLvl2.put("icon","");
        jsonObjLvl2.put("spread",true);
        jsonObjLvl2.put("href","lala.html");
        jsonObjLvl2.put("children",jsonArrL3);
        JSONArray jsonArrL2 = new JSONArray();
        jsonArrL2.add(jsonObjLvl2);

        //一级导航
        JSONObject jsonObjLvl1 = new JSONObject();
        jsonObjLvl1.put("title","一级导航");
        jsonObjLvl1.put("icon","fa-stop-circle");
        jsonObjLvl1.put("spread",true);
        jsonObjLvl1.put("href","http://www.baidu.com");
        jsonObjLvl1.put("children",jsonArrL2);

        //首页
        JSONObject jsonObjHome = new JSONObject();
        jsonObjHome.put("title","首页");
        jsonObjHome.put("icon"," ");
        jsonObjHome.put("spread",true);
        jsonObjHome.put("href","");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObjHome);
        jsonArray.add(jsonObjLvl1);

        return jsonArray;
    }
}
