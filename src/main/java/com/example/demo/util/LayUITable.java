package com.example.demo.util;

import java.util.HashMap;
import java.util.List;

public class LayUITable extends HashMap<String, Object> {

    public static LayUITable tableData(Long count, List<?> data) {
        LayUITable tableData = new LayUITable();
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", count);
        tableData.put("data", data);
        return tableData;
    }
}