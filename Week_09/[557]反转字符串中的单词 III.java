//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 215 👎 0

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution0908 {

    public String reverseWords(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        for (int i = 0; i < list.size(); i++) {
            char[] cs = list.get(i).toCharArray();
            int left = 0, right = cs.length - 1;
            while (left < right) {
                char temp = cs[left];
                cs[left++] = cs[right];
                cs[right--] = temp;
            }
            list.set(i, new String(cs));
        }
        return String.join(" ", list);
    }

    public String reverseWords2(String s) {
        return Arrays.stream(s.split("\\s+")).map(v -> new StringBuilder(v).reverse().toString())
            .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(new Solution0908().reverseWords("Let's take LeetCode contest"));
        System.out.println(new Solution0908().reverseWords2("Let's take LeetCode contest"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
