package com.tool;

import java.util.HashMap;
import java.util.Map;

public class PowerfulTools {

    public static Map<String, Object> format(String code, String msg, Object data) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        resultMap.put("data", data);
        return resultMap;
    }

    public static Map<String, Object> format(String code, String msg) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        return resultMap;
    }

    /* 热门微博评估（排序）算法 */
    public static float HotBlogSort(Object likeNum, Object reshareNum, Object commentNum) {
        float ln = Float.parseFloat(String.valueOf(likeNum));
        float rn = Float.parseFloat(String.valueOf(reshareNum));
        float cn = Float.parseFloat(String.valueOf(commentNum));
        // 这里暂时 权重是写死的，后期有什么好的算法再改

        float result = (float) (ln * 0.2 + rn * 0.3 + cn * 0.5);
        System.out.println(result);
        return result;
    }

}
