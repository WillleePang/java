package com.willlee.leetcode.problems301_400;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leetcode315 {
    public static void main(String[] args) {
        Leetcode315 a = new Leetcode315();
        List<Integer> countSmaller = a.countSmaller1(new int[] { 1, 5, 3, 9, 7, 6, 5 });
        System.out.println(countSmaller.size());
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }

    class Node {
        Node left;
        Node right;
        int val;
        int count;

        Node(int val) {
            this.val = val;
            this.count = 1;
        }
    }

    public List<Integer> countSmaller1(int[] nums) {
        if (nums.length == 0)
            return new LinkedList<Integer>();
        Node root = new Node(nums[nums.length - 1]);
        List<Integer> list = new LinkedList<>();
        list.add(0);
        for (int j = nums.length - 2; j >= 0; j--) {
            list.add(search(root, nums[j]));
            root = insert(root, nums[j]);
        }
        Collections.reverse(list);
        return list;
    }

    private Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (root.val == val) {
            root.count += 1;
        } else if (root.val > val) {
            root.count += 1;
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    private int search(Node root, int val) {
        if (root == null) {
            return 0;
        }
        if (root.val < val) {
            return root.count + search(root.right, val);
        } else {
            return search(root.left, val);
        }
    }

}
