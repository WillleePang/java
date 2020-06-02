package com.willlee.leetcode.problems101_200;

import java.util.LinkedList;
import java.util.Queue;

import com.willlee.leetcode.utils.TreeNode;

public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        return help(root, root);
    }

    private boolean help(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return true;
        return left.val == right.val && help(left.left, right.right) && help(left.right, right.left);
    }

    public boolean isSymmetric1(TreeNode root) {
        return help1(root, root);
    }

    private boolean help1(TreeNode node1, TreeNode node2) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node1);
        q.offer(node2);
        while (!q.isEmpty()) {
            node1 = q.poll();
            node2 = q.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || (node1.val != node2.val)) {
                return false;
            }
            q.offer(node1.left);
            q.offer(node2.right);

            q.offer(node1.right);
            q.offer(node2.left);
        }
        return true;
    }
}
