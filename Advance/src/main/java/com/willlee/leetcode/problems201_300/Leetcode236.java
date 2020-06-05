package com.willlee.leetcode.problems201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.willlee.leetcode.utils.TreeNode;

public class Leetcode236 {

    public static void main(String[] args) {
        Leetcode236 a = new Leetcode236();
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        root.left = node5;
        root.right = node1;
        node1.left = node0;
        node1.right = node8;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        TreeNode lowestCommonAncestor = a.lowestCommonAncestor(root, node5, node4);
        System.out.println(lowestCommonAncestor.val);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> way = new ArrayList<>();
        findWay(root, way, map, p, q);
        List<TreeNode> a = map.get(p.val);
        List<TreeNode> b = map.get(q.val);
        TreeNode ans = null;
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (a.get(i).val == b.get(i).val) {
                ans = a.get(i);
            }
        }
        return ans;
    }

    private void findWay(TreeNode node, List<TreeNode> way, Map<Integer, List<TreeNode>> map, TreeNode p, TreeNode q) {
        if (node == null) {
            return;
        }
        if (node.val == p.val || node.val == q.val) {
            ArrayList<TreeNode> temp = new ArrayList<>(way);
            temp.add(node);
            map.put(node.val, temp);
        }
        if (map.containsKey(p.val) && map.containsKey(q.val)) {
            return;
        }
        way.add(node);
        findWay(node.left, way, map, p, q);
        findWay(node.right, way, map, p, q);
        way.remove(way.size() - 1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
