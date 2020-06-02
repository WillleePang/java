package com.willlee.leetcode.problems101_200;

import java.util.LinkedList;
import java.util.Queue;

import com.willlee.leetcode.utils.TreeNode;

import javafx.util.Pair;

public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        return help(root);
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(help(root.left), help(root.right)) + 1;
    }

    public int maxDepth1(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new Pair<TreeNode, Integer>(root, 1));
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> poll = queue.poll();
            TreeNode current_node = poll.getKey();
            int current_depth = poll.getValue();
            if (current_node != null) {
                depth = Math.max(depth, current_depth);
                queue.add(new Pair<TreeNode, Integer>(current_node.left, current_depth + 1));
                queue.add(new Pair<TreeNode, Integer>(current_node.right, current_depth + 1));
            }
        }
        return depth;
    }
}
