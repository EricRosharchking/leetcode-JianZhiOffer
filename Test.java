import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    
    //abcw fxyz
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        var list = threeSum(arr);
        System.out.println(list);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
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
    // int i = 0, k = nums.length - 1;
    // while (i < nums.length - 2 && nums[i] <= 0) {
    //     int j = i + 1;
    //     while (j < k) {
    //         if (nums[i] + nums[j] + nums[k] == 0) {
    //             list.add(Arrays.asList(nums[i],nums[j],nums[k]));
    //         }
    //         while (nums[j] == nums[++j]){}
    //         while (nums[k] == nums[--k]){}
    //     }
    //     while(nums[i] == nums[++i]){}
    // }
    // return list;
}
