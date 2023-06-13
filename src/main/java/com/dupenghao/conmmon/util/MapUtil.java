package com.dupenghao.conmmon.util;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杜鹏豪 on 2022/9/1.
 */
public class MapUtil {

    public static Map<String,Object> of(String key,Object value){
        HashMap<String, Object> map = new HashMap<>();
        map.put(key,value);
        return map;
    }

    public static Map<String,Object> of(Pair<String,Object>... pairs){
        HashMap<String, Object> map = new HashMap<>();
        for (Pair<String, Object> pair : pairs) {
            map.put(pair.getKey(),pair.getValue());
        }
        return map;
    }

}
