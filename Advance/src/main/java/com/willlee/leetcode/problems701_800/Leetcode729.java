package com.willlee.leetcode.problems701_800;

import java.util.ArrayList;
import java.util.List;

public class Leetcode729 {

}

// leetcode729
class MyCalendar {

    class Entry {
        int start;
        int end;

        Entry(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private List<Entry> innerList = new ArrayList<>();

    public MyCalendar() {
        innerList.add(new Entry(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    public boolean book(int start, int end) {
        int i = 0;
        for (Entry e : innerList) {
            if (end <= e.start) {
                if (i == 0) {
                    innerList.add(0, new Entry(start, end));
                    return true;
                }

                Entry prev = innerList.get(i - 1);
                if (start >= prev.end) {
                    innerList.add(i, new Entry(start, end));
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}
