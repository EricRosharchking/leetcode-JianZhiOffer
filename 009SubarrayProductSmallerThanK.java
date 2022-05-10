/**
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数
 * 输入: nums = [10,5,2,6], k = 100, 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]
 */

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int i = 0, j = 1, p = nums[0], res = 0;

        while (i < nums.length && j <= nums.length) {
            System.out.println("p:" + p + ",i:" + i + ",j:" + j);
            if (p >= k) {
                System.out.println("window shrink by one");
                p /= nums[i];
                i++;
                System.out.println("added " + (j-i));
                res += (j-i);
            } else {
                if (j < nums.length) {
                    System.out.println("window extend by one");
                    p *= nums[j];
                    j++;
                } else if (j == nums.length) {
                    System.out.println("window shrink by one, at the end");
                    System.out.println("added " + (j-i));
                    res += (j-i);
                    p /= nums[i];
                    i++;
                }
            }
            if (j < nums.length && i == j) {
                p=nums[j++];
            }
        }
        return res;
    }
}