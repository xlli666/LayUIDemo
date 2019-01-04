package com.example.demo.util;

import java.util.HashMap;

public class LayUIFailure extends HashMap<String, Object> {

    public static LayUIFailure failureInfo(int code, String msg) {
        LayUIFailure failureInfo = new LayUIFailure();
        failureInfo.put("code", code);
        failureInfo.put("msg", msg);
        return failureInfo;
    }
}
