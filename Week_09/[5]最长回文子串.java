//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2579 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution0902 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i < len; i++) {
            exentdPalindrome(s, i, i);
            exentdPalindrome(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    private int start, maxLen;

    private void exentdPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            start = j + 1;
            maxLen = k - j - 1;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
