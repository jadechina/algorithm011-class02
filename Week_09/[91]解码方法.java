//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划 
// 👍 482 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution0911 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        dp[0] = dp[1] = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] != '0') {
                dp[i + 1] = dp[i];
            }
            int num = (chars[i - 1] - '0') * 10 + (chars[i] - '0');
            if (num >= 10 && num <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Solution0911 solution0911 = new Solution0911();
        System.out.println(solution0911.numDecodings("12"));
        System.out.println(solution0911.numDecodings("226"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
