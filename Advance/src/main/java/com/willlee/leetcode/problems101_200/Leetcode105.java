package com.willlee.leetcode.problems101_200;

import java.util.HashMap;
import java.util.Stack;

import com.willlee.leetcode.utils.TreeNode;

public class Leetcode105 {

    public static void main(String[] args) {
        Leetcode105 a = new Leetcode105();
        a.buildTree2(new int[] { 4, 9, 2, 5, 7, 8, 3, 6 }, new int[] { 2, 5, 9, 4, 8, 3, 7, 6 });
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        // preorder 为空，直接返回 null
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        // 在中序遍历中找到根节点的位置
        int i_root_index = map.get(root_val);
        int leftNum = i_root_index - i_start;
        // 递归的构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        // 递归的构造右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int pre = 0;
        int in = 0;
        // 先序遍历的第一个值为根节点
        TreeNode curRoot = new TreeNode(preorder[pre]);
        TreeNode root = curRoot;
        stack.push(curRoot);
        pre++;
        while (pre < preorder.length) {
            // 出现了当前节点的值和中序遍历数组的值相等，寻找是谁的右子树
            if (curRoot.val == inorder[in]) {
                // 每次进行出栈，实现倒着遍历
                while (!stack.isEmpty() && stack.peek().val == inorder[in]) {
                    curRoot = stack.peek();
                    stack.pop();
                    in++;
                }
                // 设为当前的右孩子
                curRoot.right = new TreeNode(preorder[in]);
                curRoot = curRoot.right;
                stack.push(curRoot);
                pre++;
            } else {
                curRoot.left = new TreeNode(preorder[pre]);
                curRoot = curRoot.left;
                stack.push(curRoot);
                pre++;
            }
        }
        return root;
    }

    int pre = 0, in = 0;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return recursive(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode recursive(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length)
            return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int curVal = preorder[pre++];
        TreeNode cur = new TreeNode(curVal);
        cur.left = recursive(preorder, inorder, curVal);
        cur.right = recursive(preorder, inorder, stop);
        return cur;
    }
}
