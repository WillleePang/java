package com.willlee.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode39 40
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

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> temp) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(temp);
            return;
        }
        /*
         * 最开始我是这样去重的 但是发现会一起把重复元素组成的解去掉。比如： 输入 : [10,1,2,7,6,1,5] 8 输出 :
         * [[1,2,5],[1,7],[2,6]] 缺少了 [1,1,6] 这个解
         */
        // if (start != 0 && candidates[start] == candidates[start - 1]) {
        // return;
        // }
        /*
         * 从start到candidate末尾的元素来搜索有没有组成target的可能性 target >=
         * candidates[i]意思是，如果当前的元素已经大于target就不要往下搜索了
         */
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            /*
             * 这个是看了别人的去重方法，巧妙的利用了start位置上的元素不用搜索前面有没有重复的
             * 这一个特性。它把重复元素（[1,1,6]）的搜索任务都交给了第一个出现的元素去搜索，当 第二次出现时，就continue跳过了。
             * 另外像（[1,2,5],[1,7]）其中的1也是第一个1而不是第二个1。
             */
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            } else {
                List<Integer> newTemp = new ArrayList<>(temp);
                newTemp.add(candidates[i]);
                // 这里的i + 1也不能写成++ i
                backTrack(candidates, target - candidates[i], i + 1, res, newTemp);
            }
        }
    }
}
