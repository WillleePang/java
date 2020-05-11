package com.willlee.leetcode.problems101_200;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.willlee.leetcode.utils.TreeNode;

public class Leetcode104 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return null;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Deque<TreeNode> res = new LinkedList<TreeNode>();
        res.add(root);
        while (!res.isEmpty()) {
            int size = res.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode poll = res.poll();
                list.add(poll.val);
                if (poll.left != null)
                    res.addLast(poll.left);
                if (poll.right != null)
                    res.addLast(poll.right);
            }
            ans.add(list);
        }
        return ans;
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
        Leetcode104 a = new Leetcode104();
        a.levelOrder(root);
    }

}
