import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0
 * 且 不重复 的三元组
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 1, k = nums.length - 1;
            while (j < k && k > 1) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    while(k > 1 && nums[k] == nums[--k]){};
                } else if (nums[i] + nums[j] + nums[k] == 0) {
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (j < k && nums[j] == nums[++j]) {};
                    while(k > 1 && nums[k] == nums[--k]){};
                } else {
                    while (j < k && nums[j] == nums[++j]) {};
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[++i]){};
        }
        return list;
    }
}