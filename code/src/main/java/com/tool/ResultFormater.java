package com.tool;

import java.util.HashMap;
import java.util.Map;

public class ResultFormater {

    public static Map<String, Object> format(String code, String msg, Object data) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        resultMap.put("data", data);
        return resultMap;
    }

}
