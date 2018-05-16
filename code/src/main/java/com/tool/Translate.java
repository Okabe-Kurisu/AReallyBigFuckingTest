package com.tool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amadeus on 2018/5/16.
 */

/*
* 使用方法
* Translate api = new Translate();
  String query = "哈哈哈哈";
  System.out.println(api.trans2EN(query));
* */
public class Translate {
    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";
    private String appid = "20180516000160326";
    private String securityKey = "BAgmOeSHQAaiouoopnzY";

    public String getTransResult(String query, String from, String to) {
        Map<String, String> params = buildParams(query, from, to);
        return HttpGet.get(TRANS_API_HOST, params);
    }

    public String trans2CN(String query) {
        Map<String, String> params = buildParams(query, "en", "zh");
        return HttpGet.get(TRANS_API_HOST, params);
    }

    public String trans2EN(String query) {
        Map<String, String> params = buildParams(query, "auto", "en");
        return HttpGet.get(TRANS_API_HOST, params);
    }


    private Map<String, String> buildParams(String query, String from, String to) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);

        params.put("appid", appid);

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // 签名
        String src = appid + query + salt + securityKey; // 加密前的原文
        params.put("sign", MD5.md5(src));

        return params;
    }


}