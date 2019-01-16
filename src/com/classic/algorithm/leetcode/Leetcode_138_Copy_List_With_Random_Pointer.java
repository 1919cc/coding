package com.classic.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

public class Leetcode_138_Copy_List_With_Random_Pointer {
    Map<RandomListNode, RandomListNode> map =
            new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        if (map.containsKey(head)) return map.get(head);
        
        RandomListNode node = new RandomListNode(head.label);
        map.put(head, node);
        
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        
        return node;
    }
    // Time O(N), Space O(N)
    
    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode ptr = head;
        
        while (ptr != null) {
            RandomListNode newNode = new RandomListNode(ptr.label);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }
        
        ptr = head;
        
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        
        RandomListNode ptr_old_list = head;
        RandomListNode ptr_new_list = head.next;
        RandomListNode newHead = head.next;
        
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        
        return newHead;
    }
    // Time O(N), Space O(1)
}