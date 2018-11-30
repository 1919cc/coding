package com.classic.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_68Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        
        int len = 0;
        int i = 0;
        
        Queue<String> queue = new LinkedList<>();
        
        int cnt = 0;
        
        while (i < words.length) {
            if (len + words[i].length() < maxWidth) {
                len += words[i].length() + 1;
                queue.offer(words[i++]);
                cnt++;
            } else if (len + words[i].length() == maxWidth) {
                StringBuilder sb = new StringBuilder();
                
                while (!queue.isEmpty()) {
                    sb.append(queue.poll() + " ");
                }
                
                sb.append(words[i++]);
                
                res.add(sb.toString());
                len = 0;
                cnt = 0;
            } else if (cnt != 1){
                StringBuilder sb = new StringBuilder();
                
                int spaceSlot = (maxWidth - (len-cnt)) / (cnt-1);
                int extraSpace = (maxWidth - (len-cnt)) % (cnt-1);
                
                while (queue.size() > 1) {
                    sb.append(queue.poll());
                    
                    for (int j = 0; j < spaceSlot; j++) sb.append(" ");
                    if (extraSpace-- > 0) sb.append(" ");
                }
                sb.append(queue.poll());
                res.add(sb.toString());
                len = 0;
                cnt = 0;
            } else if (cnt == 1){
                StringBuilder sb = new StringBuilder();
                sb.append(queue.poll());
                while (sb.length() < maxWidth) sb.append(" ");
                res.add(sb.toString());
                len = 0;
                cnt = 0;
            }
        }
        
        if (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            while (queue.size() > 1) {
                sb.append(queue.poll() + " ");
            }
            sb.append(queue.poll());
            while (sb.length() < maxWidth) sb.append(" ");
            res.add(sb.toString());
        }

        return res;
    }
}
