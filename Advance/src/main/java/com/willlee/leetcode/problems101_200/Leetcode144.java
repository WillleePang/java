package com.willlee.leetcode.problems101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.willlee.leetcode.utils.TreeNode;

public class Leetcode144 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null)
                preorderTraversal(root.left);
            if (root.right != null)
                preorderTraversal(root.right);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;
        Leetcode144 a = new Leetcode144();
        a.preorderTraversal(root);
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
        return res;
    }
}
