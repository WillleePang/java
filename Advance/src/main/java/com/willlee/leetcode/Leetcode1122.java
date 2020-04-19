package com.willlee.leetcode;

public class Leetcode1122 {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		// 由于arr1的可能取值为0-1000，共1001个取值，不算一个很大的取值范围，所以可以利用桶式排序
		int[] bucket = new int[1001];
		// 计数每个桶有多少个数，也就是每个值在数组中有几个
		for (int num : arr1) {
			bucket[num]++;
		}
		// 由于重新排序不会改变数组的长度，所以可以利用原数组，可以节省空间复杂度
		int i = 0;
		for (int num : arr2) {
			while (bucket[num]-- > 0) {
				arr1[i++] = num;
			}
		}
		// 未在arr2中的桶中的数，按照桶号升序进行输出，所以进行二次遍历
		for (int j = 0; j < 1001; ++j) {
			while (bucket[j]-- > 0) {
				arr1[i++] = j;
			}
		}
		return arr1;
	}
}
