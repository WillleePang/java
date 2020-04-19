package com.willlee.leetcode;

import java.util.ArrayList;

public class Leetcode1146 {
	SnapshotArray sa = new SnapshotArray(10);
}

class SnapshotArray {
	// 使用ArrayList来维护数组，每个数组元素又是一个ArrayList，对应该位置的不同快照版本
	// 采用增量式的方式，更新快照的时候，只更新必要的位置，其他位置不变
	private ArrayList<ArrayList<Integer>> list;
	private int id = 0;

	public SnapshotArray(int length) {
		list = new ArrayList<>(length);
		for (int i = 0; i < length; i++) {
			ArrayList<Integer> each = new ArrayList<Integer>();
			each.add(0);
			list.add(each);
		}
	}

	public void set(int index, int val) {
		// 获取对应位置的链表
		ArrayList<Integer> l = list.get(index);
		// 如果版本更新了，例如如果此时id为1，但是l.size()为1，那么表示该位置还是快照版本0时候的值
		if (id > l.size() - 1) {
			// 这里注意，由于此位置可能很多个快照版本都没变，所以需要取出它最后修改的值，然后复制id - i次，使它达到当前版本
			// 例如，如果i=1，即当前位置还是初始化为0后就没变过，但是当前版本已经到3，即id=3
			// 那么就需要再复制2个0，补上版本1、2的值，然后再更新版本3
			int i = l.size();
			int src = l.get(i - 1);
			while (i < id) {
				l.add(src);
				i++;
			}
			l.add(val);
		}
		// 如果没更新，修改当前版本的值
		else
			l.set(id, val);
	}

	public int snap() {
		return id++;
	}

	public int get(int index, int snap_id) {
		ArrayList<Integer> each = list.get(index);
		// 如果对应的版本号超过对应位置的长度-1，说明该位置值在某个版本后没变过，所以取最后一个版本的值就行了
		if (snap_id > each.size() - 1)
			return each.get(each.size() - 1);
		// 如果该位置含有该版本，那么取对应该版本的值
		else
			return each.get(snap_id);
	}
}