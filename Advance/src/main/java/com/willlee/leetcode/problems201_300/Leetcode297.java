package com.willlee.leetcode.problems201_300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.willlee.leetcode.utils.TreeNode;

public class Leetcode297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    private String rserialize(TreeNode root, String str) {
        if (root == null) {
            return str + "null";
        } else {
            str += root.val + ",";
            rserialize(root.left, str);
            rserialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(array));
        return rdeserialize(list);
    }

    private TreeNode rdeserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);
        return root;
    }
}
