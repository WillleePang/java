package com.willlee.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<Boolean>();
        int state = 0;
        for (int i = 0; i < A.length; i++) {
            state = ((state << 1) + A[i]) % 5;
            if (state == 0)
                res.add(Boolean.TRUE);
            else
                res.add(Boolean.FALSE);
        }
        return res;
    }
}
