package com.willlee.leetcode.problems1_100;

import java.util.Stack;

import com.willlee.leetcode.utils.TreeNode;

public class Leetcode98 {
    public static void main(String[] args) {
        Leetcode98 a = new Leetcode98();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(6);
        n2.left = n1;
        n2.right = n3;
        n3.left = n4;
        n3.right = n5;
        boolean b = a.isValidBST(n2);
        System.out.println(b);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;
        int val = node.val;
        if (lower != null && val <= lower)
            return false;
        if (upper != null && val >= upper)
            return false;
        if (!helper(node.right, val, upper))
            return false;
        if (!helper(node.left, lower, val))
            return false;
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder)
                return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    long pre = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

}