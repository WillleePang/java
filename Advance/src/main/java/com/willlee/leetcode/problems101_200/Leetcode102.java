package com.willlee.leetcode.problems101_200;

import java.util.ArrayList;
import java.util.List;

import com.willlee.leetcode.utils.TreeNode;

public class Leetcode102 {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode root, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(root.val);
        if (root.left != null)
            helper(root.left, level + 1);
        if (root.right != null)
            helper(root.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return levels;
        helper(root, 0);
        return levels;
    }
}
