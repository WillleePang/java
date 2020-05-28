package com.willlee.leetcode.problems301_400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leetcode315 {
	public static void main(String[] args) {
		Leetcode315 a = new Leetcode315();
		List<Integer> countSmaller = a.countSmaller2(new int[] {5,2,6,1});
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

	private int[] temp;
	private int[] counter;
	private int[] indexes;

	public List<Integer> countSmaller2(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int len = nums.length;
		if (len == 0) {
			return res;
		}
		temp = new int[len];
		counter = new int[len];
		indexes = new int[len];
		for (int i = 0; i < len; i++) {
			indexes[i] = i;
		}
		mergeAndCountSmaller(nums, 0, len - 1);
		for (int i = 0; i < len; i++) {
			res.add(counter[i]);
		}
		return res;
	}

	/**
	 * 针对数组 nums 指定的区间 [l, r] 进行归并排序，在排序的过程中完成统计任务
	 *
	 * @param nums
	 * @param l
	 * @param r
	 */
	private void mergeAndCountSmaller(int[] nums, int l, int r) {
		if (l == r) {
			// 数组只有一个元素的时候,没有比较,不统计
			return;
		}
		int mid = l + (r - l) / 2;
		mergeAndCountSmaller(nums, l, mid);
		mergeAndCountSmaller(nums, mid + 1, r);
		// 归并排序的优化,同样适用于该问题
		// 如果索引数组有序,就没有必要再继续计算了
		if (nums[indexes[mid]] > nums[indexes[mid + 1]]) {
			mergeOfTwoSortedArrAndCountSmaller(nums, l, mid, r);
		}
	}

	/**
	 * [l, mid] 是排好序的 [mid + 1, r] 是排好序的
	 *
	 * @param nums
	 * @param l
	 * @param mid
	 * @param r
	 */
	private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int l, int mid, int r) {
		// 3,4 1,2
		for (int i = l; i <= r; i++) {
			temp[i] = indexes[i];
		}
		int i = l;
		int j = mid + 1;
		// 左边出列的时候,计数
		for (int k = l; k <= r; k++) {
			if (i > mid) {
				indexes[k] = temp[j];
				j++;
			} else if (j > r) {
				indexes[k] = temp[i];
				i++;
				// 此时j用完了 【7,8,9 | 1,2,3]
				// 之前的数就和后面的区间长度构成逆序
				counter[indexes[k]] += (r - mid);
			} else if (nums[temp[i]] <= nums[temp[j]]) {
				indexes[k] = temp[i];
				i++;
				// 此时 [4,5, 6 | 1,2,3 10 12 13]
				// mid j
				counter[indexes[k]] += (j - mid - 1);
			} else {
				// nums[indexes[i]] > nums[indexes[j]] 构成逆序
				indexes[k] = temp[j];
				j++;
			}
		}
	}

}
