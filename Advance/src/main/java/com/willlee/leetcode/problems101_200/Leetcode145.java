package com.willlee.leetcode.problems101_200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.willlee.leetcode.utils.TreeNode;

public class Leetcode145 {
    public List<Integer> postorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.right;
            } else {
                TreeNode pop = stack.pop();
                root = pop.left;
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    List<Integer> helper(TreeNode node, List<Integer> ans) {
        if (node.left != null) {
            helper(node.left, ans);
        }
        if (node.right != null) {
            helper(node.right, ans);
        }
        ans.add(node.val);
        return ans;
    }

}
