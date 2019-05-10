package com.willlee.leetcode.list;

import java.util.HashSet;
import java.util.Set;

public class NumComponents {
    public int numComponents1(ListNode head, int[] G) {
        // 先创建一个hash数组，hash[i]=1表示i在G中出现过
        int max = G[0];
        for (int i : G) {
            max = Math.max(max, i);
        }
        int[] hash = new int[max + 1];
        for (int i = 0; i < G.length; i++) {
            hash[G[i]] = 1;
        }
        ListNode cur = head;
        int sum = 0;
        int len = 0;// len表示这个子串能到的最大长度
        while (cur != null) {
            if (cur.val <= max && hash[cur.val] == 1) { // 这个链表节点在G中
                len++;
            } else {
                if (len > 0) // 如果当前节点不在，那么只要len>0,说明之前也有串
                    sum++;
                len = 0; // 重置len;
            }
            cur = cur.next;
        }
        if (len > 0) // 这种情况是链表遍历完了的情况，但最后一个串没有累计
            sum++;
        return sum;
    }

    public int numComponents2(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int num : G) {
            set.add(num);
        }
        int count = 0;
        ListNode pre = head;
        while (head != null) {
            if (set.contains(pre.val) && !set.contains(head.val)) {
                count++;
            }
            pre = head;
            head = head.next;
        }
        if (set.contains(pre.val)) {
            count++;
        }
        return count;
    }

    public int numComponents3(ListNode head, int[] G) {
        int[] shuzu = new int[10000];
        for (int i = 0; i < G.length; i++) {
            shuzu[G[i]] = 1;
        }
        int result = 0;
        int change = 0;
        while (head != null) {
            while (head != null && shuzu[head.val] == 1) {
                change = 1;
                head = head.next;
            }
            if (change == 1) {
                result++;
                change = 0;
            }
            if (head != null)
                head = head.next;
            else
                return result;
        }
        return result;
    }

    // 记录一下：这个题目还是比较好理解的，遍历一次链表，判断链表节点存储的值是否在数组G中，进行可以计算出组件的个数。假设链表长度为L，数组G的长度为M，暴力法的时间复杂度为O(N*M)，空间复杂度为O(1)。可以优化的点在于判断链表节点存储的值是否在于数组G的算法上，题目中写到链表长度最大为10000，可以利用空间换时间，创建一个长度为10000的布尔值类型(占据空间最少)数组A，默认存储值为false,
    // 数组G中对应的值对应索引的值为true，这样根据链表节点存储的值判断是否存在于数组G的问题就可以转换为数组A某索引上对应值的问题，时间复杂度由O(M)
    // 优化为 O(1)， 这样本题算法时间复杂度为
    // O(N)，空间复杂度为O(10000)。后续若有类似的数组判断的问题，条件允许的情况下可以使用类似的空间换时间的方法进行时间复杂度的优化。最后是代码:

    public int numComponents4(ListNode head, int[] G) {
        int num = 0;
        boolean[] A = new boolean[10000];
        for (int i : G) {
            A[i] = true;
        }

        ListNode p = head;
        while (p != null) {
            if (A[p.val]) {
                while (p.next != null && A[p.next.val]) {
                    p = p.next;
                }
                num++;
            }
            p = p.next;
        }

        return num;
    }
}
