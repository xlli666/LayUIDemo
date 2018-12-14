package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;

public class LayUIUpload extends HashMap<String, Object> {
    public static LayUIUpload uploadResData(String imgUrl){
        Map<String, String> srcMap = new HashMap<>();
        srcMap.put("src",imgUrl);
        LayUIUpload uploadResData = new LayUIUpload();
        uploadResData.put("code", 0);
        uploadResData.put("msg","");
        uploadResData.put("data",srcMap);
        return uploadResData;
    }
}
