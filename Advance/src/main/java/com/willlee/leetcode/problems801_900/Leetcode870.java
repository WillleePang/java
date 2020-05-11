package com.willlee.leetcode.problems801_900;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 
 * @author pangwilllee
 *
 *         思想： 田忌赛马 每次拿A的“当前轮次“的最小值和B的”当前轮次“最小值比较， 若大于，则OK，满足。
 *         若小于，则将A的值去和B的”最大值“配对。
 * 
 *         技巧： 将B的“值”和“索引”封装为Node对象，便于排序后找到原索引位置，个人认为比用其他方式好一些。
 *         使用LinkedList维护封装好的B的Node对象，方便移除头尾节点(结合思想中的两步，头尾节点即对应最小，最大值)
 * 
 */
public class Leetcode870 {
	public int[] advantageCount(int[] A, int[] B) {
		Arrays.sort(A);
		LinkedList<Node> listB = new LinkedList<>();
		for (int i = 0; i < B.length; i++) {
			listB.add(new Node(B[i], i));
		}
		Collections.sort(listB, new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return n1.value - n2.value;
			}
		});

		// 遍历A即可，将B数组作为输出容器，因为B的信息已经都存在LinkedList里了，这里B数组已经没用了
		for (int i = 0; i < A.length; i++) {
			if (A[i] > listB.getFirst().value) {
				B[listB.removeFirst().index] = A[i]; // 若大于，则OK
			} else { 
				B[listB.removeLast().index] = A[i]; // 若小于，则将A的值去和B的”最大值“配对
			}
		}
		
		return B;
	}
}

class Node {
	int value;
	int index;

	public Node(int value, int index) {
		this.value = value;
		this.index = index;
	}
}
