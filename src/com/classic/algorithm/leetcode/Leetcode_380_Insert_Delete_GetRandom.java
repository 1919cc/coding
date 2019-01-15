package com.classic.algorithm.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Leetcode_380_Insert_Delete_GetRandom {
    Map<Integer, Integer> map;
    List<Integer> array;
    Random rand;

    /** Initialize your data structure here. */
    public Leetcode_380_Insert_Delete_GetRandom() {
        map = new HashMap<>();
        array = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, array.size());
        array.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.remove(val);
        int last = array.remove(array.size()-1);
        if (last != val) {
            array.set(idx, last);
            map.put(last, idx);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return array.get(rand.nextInt(array.size()));
    }
}
