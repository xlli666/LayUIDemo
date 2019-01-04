package com.example.demo.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LayUISuccess extends HashMap<String, Object> {

    final private static int CODE = 0;

    final private static String MSG = "";

    public static LayUISuccess tableData(Long count, List<?> data) {
        LayUISuccess tableResult = new LayUISuccess();
        tableResult.put("code", CODE);
        tableResult.put("msg", MSG);
        tableResult.put("count", count);
        tableResult.put("data", data);
        return tableResult;
    }
    public static LayUISuccess formSubResData(String result) {
        LayUISuccess formSubmitResult = new LayUISuccess();
        formSubmitResult.put("code",CODE);
        formSubmitResult.put("msg",MSG);
        formSubmitResult.put("data",result);
        return formSubmitResult;
    }
    public static LayUISuccess uploadResData(String imgUrl) {
        Map<String, String> srcMap = new HashMap<>();
        srcMap.put("src",imgUrl);
        LayUISuccess uploadResult = new LayUISuccess();
        uploadResult.put("code", CODE);
        uploadResult.put("msg",MSG);
        uploadResult.put("data",srcMap);
        return uploadResult;
    }
}
