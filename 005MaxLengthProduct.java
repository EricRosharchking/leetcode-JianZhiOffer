import java.util.Arrays;

/**
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j]
 * 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 * ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 
 */
class Solution {
    public int maxProduct(String[] words) {
        int l = words.length;
        if (l <= 1) {
            return 0;
        }

        int[] charOccurrenceBits = new int[l];
        for (int i = 0; i < l; i++) {
            int bit = 0;
            char[] word = words[i].toCharArray();
            for (int j = 0; j < word.length; j++) {
                bit |= (1 << (word[j] - 'a'));
            }
            charOccurrenceBits[i] = bit;
        }
        int[][] commonChars = new int[l][l];

        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if ((charOccurrenceBits[i] ^ charOccurrenceBits[j]) == 0) {
                    commonChars[i][j] = 1;
                }
            }
        }
        for (int[] arr : commonChars) {
            System.out.println(Arrays.toString(arr));
        }

        int res = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (commonChars[i][j] == 1) {
                    int tmp = words[i].length() * words[j].length();
                    res = res > tmp ? res : tmp;
                }
            }
        }
        return res;
    }

    public boolean contains(String a, String b) {
        int[] arr1 = a.chars().distinct().sorted().toArray();
        int[] arr2 = b.chars().distinct().sorted().toArray();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                return true;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }
}