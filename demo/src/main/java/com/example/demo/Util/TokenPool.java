package com.example.demo.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TokenPool {

    private static Logger logger = LoggerFactory.getLogger(TokenPool.class);

    private static int maximumTokenValid = 1000 * 60 * 30;
    private static int maximumTokenNum = 128;
    // token - 创造时间 映射
    private static ConcurrentHashMap<String, Long> tokenTimePool = new ConcurrentHashMap<>();
    // token - userId 映射
    private static ConcurrentHashMap<String, Integer> tokenUserPool = new ConcurrentHashMap<>();

    public static void setToken(String token, Integer userId) {
        long currentTime = System.currentTimeMillis();
        tokenTimePool.put(token, currentTime);
        tokenUserPool.put(token, userId);
        if (tokenTimePool.size() > maximumTokenNum) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    HashSet<String> expiredToken = new HashSet<>();
                    for (Map.Entry entry : tokenTimePool.entrySet()) {
                        if (currentTime - (Long) entry.getValue() >= maximumTokenValid) {
                            expiredToken.add((String) entry.getKey());
                        }
                    }
                    for (String token : expiredToken) {
                        deleteToken(token);
                    }
                }
            }).start();
        }
    }

    public static void deleteToken(String token) {
        tokenTimePool.remove(token);
        tokenUserPool.remove(token);
    }

    public static Integer getUser(String token) {
        long currentTime = System.currentTimeMillis();
        long originTime = tokenTimePool.containsKey(token) ? tokenTimePool.get(token) : -1;
        if (originTime == -1) {
            return null;
        }
        if (currentTime - originTime >= maximumTokenValid) {
            tokenTimePool.remove(token);
            tokenUserPool.remove(token);
            return null;
        }
        return tokenUserPool.get(token);
    }



    /**
     * 通过 uuid 生成唯一 token
     * @return
     */
    public static String getUUID() {
        String token = UUID.randomUUID().toString().replace("-","").toLowerCase();
        return token;
    }
}
