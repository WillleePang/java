package com.willlee.leetcode.problems301_400;

import java.util.HashMap;

import com.willlee.leetcode.utils.TreeNode;

public class Leetcode337 {

    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode node) {
        if (node == null)
            return new int[2];
        int[] result = new int[2];
        int[] left = robInternal(node.left);
        int[] right = robInternal(node.right);
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + node.val;
        return result;
    }

    public int rob1(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return robInternal1(root, memo);
    }

    public int robInternal1(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (root == null)
            return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        int money = root.val;

        if (root.left != null) {
            money += (robInternal1(root.left.left, memo) + robInternal1(root.left.right, memo));
        }
        if (root.right != null) {
            money += (robInternal1(root.right.left, memo) + robInternal1(root.right.right, memo));
        }
        int result = Math.max(money, robInternal1(root.left, memo) + robInternal1(root.right, memo));
        memo.put(root, result);
        return result;
    }

    public int rob2(TreeNode root) {
        if (root == null)
            return 0;
        int money = root.val;
        if (root.left != null)
            money += rob2(root.left.left) + rob2(root.left.right);
        if (root.right != null)
            money += rob2(root.right.left) + rob2(root.right.right);
        return Math.max(money, rob2(root.left) + rob2(root.right));
    }
}
