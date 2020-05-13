package com.willlee.leetcode.problems101_200;

import java.util.ArrayList;

import com.willlee.leetcode.utils.TreeNode;

public class Leetcode173 {

}

class BSTIterator {

    ArrayList<Integer> list;
    int index;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        index = -1;
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }

    public int next() {
        return list.get(++index);
    }

    public boolean hasNext() {
        return index + 1 < list.size();
    }
}