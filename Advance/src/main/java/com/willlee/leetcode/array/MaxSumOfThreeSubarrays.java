package com.willlee.leetcode.array;

public class MaxSumOfThreeSubarrays {
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[3];
        int[] sum = new int[n + 1];
        int[] left = new int[n];
        int[] right = new int[n];

        // sum start from 0 ... n
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        // left[i] means the start index of maximum sum subarray from 0...i,
        // return the leftmost result
        for (int i = k, total = sum[k] - sum[0]; i < n; i++) {
            if (sum[i + 1] - sum[i - k + 1] > total) {
                total = sum[i + 1] - sum[i - k + 1];
                left[i] = i - k + 1;
            } else {
                left[i] = left[i - 1];
            }
        }

        // right[i] same with the left[i] from i...n-1, but start from n - k - 1
        // assume k = 2, right should start from n - 3
        right[n - k] = n - k;
        for (int i = n - k - 1, total = sum[n] - sum[n - k]; i >= 0; i--) {
            // n - 1 - (n - k - 1) = k
            // why >= : because of the leftmost result
            if (sum[i + k] - sum[i] >= total) {
                total = sum[i + k] - sum[i];
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }
        // 选一个长度为k，max多少？
        // F[i] = nums[1...end]
        // 选两个长度为k，max多少？
        // S[i] = nums[1..end]= max(S[i+1], sum(nums[i...i+k-1]) + F[i+k])
        // 选三个长度为k的，max多少呢？
        // Z[i] = max(Z[i+1], sum(nums[i...i+k-1]) + max(S[i+k+1],
        // sum(nums[i+k...i+2k-1]) + F[i+2k]))
        int maxsum = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1], r = right[i + k];
            int total = sum[l + k] - sum[l] + sum[r + k] - sum[r] + sum[i + k] - sum[i];
            if (total > maxsum) {
                res[0] = l;
                res[1] = i;
                res[2] = r;
                maxsum = total;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 1, 2, 6, 7, 5, 1 };
        maxSumOfThreeSubarrays(a, 2);
    }

}
