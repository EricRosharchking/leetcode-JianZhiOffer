/**
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 */

class Soluction {
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        int[] sums = new int[nums.length];
        // for (int i = 0; i< nums.length; i++) {
        //     sum += nums[i];
        //     sums[i] = sum;
        // }

        sum = 0;
        int i = 0, j = 0;
        while ( i < nums.length && j < nums.length) {
            if (sum < k) {
                sum += nums[i++];
            } else if (sum == k) {
                res ++;
                i++;
                j++;
            } else {
                sum -= nums[j++];
            }
        }

        return res;
    }
}
