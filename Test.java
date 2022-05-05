import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    // abcw fxyz
    public static void main(String[] args) {
        int[] arr = { 1,1,1,1 };
        int k = 1;
        System.out.println(numSubarrayProductLessThanK(arr, k));
        // [][10,9,10,4,3,8,3,3,6,2,10,10,9,3][1,1,1,1][5,5,5,5]
        // 19
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
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

        // while (i < nums.length && j <= nums.length) {
        // if (j < nums.length) {
        // p *= nums[j];
        // j++;
        // }
        // System.out.println("p:" + p + ",i:" + i + ",j:" + j);
        // if (p >= k || j == nums.length) {
        // if (j == nums.length) {
        // if (p < k) {
        // res += (j - i);
        // System.out.println("added " + (j - i) + " to res");
        // }
        // p /= nums[i];
        // i++;
        // } else {
        // p /= nums[i];
        // i++;
        // if (p < k) {
        // res += (j - i);
        // System.out.println("added " + (j - i) + " to res");
        // }
        // }
        // }

        // }
        return res;
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
                    while (k > 1 && nums[k] == nums[--k]) {
                    }
                    ;
                } else if (nums[i] + nums[j] + nums[k] == 0) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[++j]) {
                    }
                    ;
                    while (k > 1 && nums[k] == nums[--k]) {
                    }
                    ;
                } else {
                    while (j < k && nums[j] == nums[++j]) {
                    }
                    ;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[++i]) {
            }
            ;
        }
        return list;
    }
    // int i = 0, k = nums.length - 1;
    // while (i < nums.length - 2 && nums[i] <= 0) {
    // int j = i + 1;
    // while (j < k) {
    // if (nums[i] + nums[j] + nums[k] == 0) {
    // list.add(Arrays.asList(nums[i],nums[j],nums[k]));
    // }
    // while (nums[j] == nums[++j]){}
    // while (nums[k] == nums[--k]){}
    // }
    // while(nums[i] == nums[++i]){}
    // }
    // return list;
}
