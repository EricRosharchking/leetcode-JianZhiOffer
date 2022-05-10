/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr]
 * ，并返回其长度。如果不存在符合条件的子数组，返回 0
 * 15
 * [5,1,3,5,10,7,4,9,2,8]
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = nums.length;
        int[] sums = new int[l + 1];
        sums[0] = 0;
        for (int i = 1; i <= l; i++) {
            if (nums[i-1] >= target) {
                return 1;
            }
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        if (sums[l] < target) {
            return 0;
        }
        if (sums[l] == target) {
            return l;
        }
        int res = l;
        int i = 1, j = 0;
        while (i <= l && j <= i) {
            if (sums[i] < target) {
                i++;
            } else if (sums[i] - sums[j] >= target) {
                j++;
                res = i - j+1;
            } else {
                i++;
                j++;
            }
        }
        return res;
    }
}