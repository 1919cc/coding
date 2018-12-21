package com.classic.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
  	TreeNode left;
  	TreeNode right;
  	TreeNode(int x) { val = x; }
}

public class Leetcode297SerializeAndDeserializeBinaryTree {
    // BFS - Time O(N), Space O(N)
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n == null) {
                sb.append("n ");
                continue;
            }
            
            sb.append(n.val + " ");
            queue.add(n.left);
            queue.add(n.right);
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] nodes = data.split(" ");
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        for (int i = 1; i < nodes.length; i++) {
            TreeNode n = queue.poll();
            
            if (!nodes[i].equals("n")) {
                n.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(n.left);
            }
            
            if (!nodes[++i].equals("n")) {
                n.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(n.right);
            }
        }
        
        return root;
    }
    
    
    // BFS - Time O(N), Space O(N)
    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    public void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) sb.append("n ");
        else {
            sb.append(root.val + " ");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        LinkedList<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(data.split(" ")));
        return buildTree(list);
    }
    
    public TreeNode buildTree(LinkedList<String> list) {
        String n = list.remove();
        
        if (n.equals("n")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(n));
        root.left = buildTree(list);
        root.right = buildTree(list);
        
        return root;
    }
}