package com.classic.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Leetcode535Encode_and_Decode_TinyURL {
    Map<Integer, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longUrl == null) return null;
        int key = longUrl.hashCode();
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
    
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rand = new Random();
    String key = getRand();
    
    public String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }
    
    Map<String, String> map2 = new HashMap<>();
    public String encode2(String longUrl) {
        while (map.containsKey(key)) {
            key = getRand();
        }
        map2.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }
    
    // Decodes a shortened URL to its original URL.
    public String decode2(String shortUrl) {
        return map2.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}
