package com.willlee.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode39
public class CombinationSum {
    // 做该题的重要条件是无重复的数组，那么问题就很好解了。首先对数组从大到小排序。这是解题的关键。
    // 1、target循环减去一个数，如果能一直减到到差值等于0，那么这个数组成的数组就是一个解,比如[2,2,2,2];
    // 2、target减去一个数，然后形成了一个新的newTarget=target-num[i],让这个newTarget减去下一个数num[i+1],然后执行步骤1，则又是一个解，比如[2,3,3];
    // （其实步骤1是步骤2的一个特例）
    // 3、target减去一个数，然后形成了一个新的newTarget=target-num[i],让这个newTarget减去下一个数num[i+1]，如果能一直减到到差值等于0说明又是一个解.，比如[3,5];
    // 如此得到了一个规律，只要是相见之后得到差值=0,就说明就得到一个解
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 重要的要大小排列
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return res;
        }
        find(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void find(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int start) {
        // target==0.找到一个新的解
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                int num = candidates[i];
                if (num <= target) {
                    tmp.add(num);
                    // 查找新的target
                    int newTarget = target - num;
                    find(res, tmp, candidates, newTarget, i);
                    tmp.remove(tmp.size() - 1);
                }
            } // end for
        }

    }

}
