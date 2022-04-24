/**
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * 
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        while (i >= 0 || j >= 0 || c != 0) {
            int ii = i >= 0 ? a.charAt(i--) - '0' : 0;
            int jj = j >= 0 ? b.charAt(j--) - '0' : 0;
            c = ii + jj + c;
            sb.append(c % 2);
            c /= 2;
        }
        return sb.reverse().toString();
    }
}