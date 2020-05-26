package com.willlee.leetcode.problems1301_1400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.willlee.leetcode.utils.TreeNode;

public class Leetcode1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<Integer>();
        visit(root1, list);
        visit(root2, list);
        Collections.sort(list);
        return list;
    }

    private void visit(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            visit(root.left, list);
            visit(root.right, list);
        }
    }
}
