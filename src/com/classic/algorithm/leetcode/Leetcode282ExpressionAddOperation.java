package com.classic.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []
 *
 */

public class Leetcode282ExpressionAddOperation {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        helper(num, target, new StringBuilder(), 0, 0, res);
        return res;
    }
    
    public void helper(String num, int target, StringBuilder resStr, long curRes, long preNum, List<String> res) {
        if (num.length() == 0) {
            if (curRes == target)res.add(resStr.toString());
            return;
        }
        
        for (int i = 1; i <= num.length(); i++) {
            String curStr = num.substring(0, i);
            if (curStr.length() > 1 && curStr.charAt(0) == '0') return;
            long curLong = Long.parseLong(curStr);
            String next = num.substring(i);
            int len = resStr.length();
            
            if (resStr.length() != 0) {
                helper(next, target, resStr.append("*").append(curStr), curRes - preNum + preNum*curLong, preNum*curLong, res);
                resStr.setLength(len);
                helper(next, target, resStr.append("+").append(curStr), curRes + curLong, curLong, res);
                resStr.setLength(len);
                helper(next, target, resStr.append("-").append(curStr), curRes - curLong, -curLong, res);
                resStr.setLength(len);
            } else {
                helper(next, target, resStr.append(curStr), curLong, curLong, res);
                resStr.setLength(len);
            }
        }
    }
}
