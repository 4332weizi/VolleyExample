package net.funol.volleyexample.http;

import java.util.HashMap;
import java.util.Map;

public class APIResultQueue {

    private static Map<String, Object> resultMap = new HashMap<>();

    public static String putResult(String url, Object obj) {
        String key = System.currentTimeMillis() + ":" + url;
        resultMap.put(key, obj);
        return key;
    }

    public static Object getResult(String key) {
        Object obj = resultMap.get(key);
        resultMap.remove(key);
        return obj;
    }
}
