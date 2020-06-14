package com.willlee.leetcode.problems101_200;

import com.willlee.leetcode.utils.TreeNode;

public class Leetcode124 {
    public static void main(String[] args) {
        Leetcode124 a = new Leetcode124();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        int ans = a.maxPathSum(root);
        System.out.println(ans);
    }
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ss(root);
        return ans;
    }

    private int ss(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = Math.max(0, ss(node.left));
        int r = Math.max(0, ss(node.right));
        int sum = l + r + node.val;
        ans = Math.max(ans, sum);
        return Math.max(l, r) + node.val;
    }
}
