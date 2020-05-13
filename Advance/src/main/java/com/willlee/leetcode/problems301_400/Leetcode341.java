package com.willlee.leetcode.problems301_400;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.willlee.leetcode.utils.NestedInteger;

public class Leetcode341 {

}

class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int i;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<Integer>();
        i = 0;
        help(nestedList);
    }

    private void help(List<NestedInteger> nestedList) {
        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                list.add(item.getInteger());
            } else {
                help(item.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(i++);
    }

    @Override
    public boolean hasNext() {
        return i < list.size();
    }
}