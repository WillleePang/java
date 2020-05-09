package com.willlee.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.willlee.leetcode.tree.TreeNode;

public class Leetcode103 {

    protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
        if (level >= results.size()) {
            LinkedList<Integer> newLevel = new LinkedList<Integer>();
            newLevel.add(node.val);
            results.add(newLevel);
        } else {
            if (level % 2 == 0)
                results.get(level).add(node.val);
            else
                results.get(level).add(0, node.val);
        }

        if (node.left != null)
            DFS(node.left, level + 1, results);
        if (node.right != null)
            DFS(node.right, level + 1, results);
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        DFS(root, 0, results);
        return results;
    }

    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Deque<TreeNode> res = new LinkedList<TreeNode>();
        if (root == null)
            return ans;
        boolean reverse = false;
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
            if (reverse)
                Collections.reverse(list);
            ans.add(list);
            reverse = !reverse;
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
        Leetcode103 a = new Leetcode103();
        a.levelOrder(root);
    }

}
