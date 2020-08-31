//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 381 👎 0

import javafx.util.Pair;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution0407 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String, List<String>> map = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String workMark = word.substring(0, i) + "*" + word.substring(i + 1, len);
                List<String> trans = map.getOrDefault(workMark, new ArrayList<>());
                trans.add(word);
                map.put(workMark, trans);
            }
        });
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.remove();
            String word = pair.getKey();
            Integer level = pair.getValue();
            for (int i = 0; i < len; i++) {
                String workMark = word.substring(0, i) + "*" + word.substring(i + 1, len);
                for (String newWord : map.getOrDefault(workMark, new ArrayList<>())) {
                    if (newWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(newWord)) {
                        visited.put(newWord, true);
                        queue.add(new Pair<>(newWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class Solution0704 {
    public int ladderLength(String beginWord, String endWord, List<String> _wordList) {
        if (_wordList == null || _wordList.size() == 0) {
            return 0;
        }
        Set<String> wordList = new HashSet<>(_wordList);
        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        int count = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] cs = word.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = cs[i];
                        cs[i] = c;
                        String target = String.valueOf(cs);
                        boolean isExists = wordList.contains(target);
                        if (isExists && endSet.contains(target)) {
                            return count + 1;
                        }
                        if (!visited.contains(target) && isExists) {
                            temp.add(target);
                            visited.add(target);
                        }
                        cs[i] = old;
                    }
                }
            }
            beginSet = temp;
            count++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int res = new Solution0704().ladderLength("hit", "cog",
            Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println("ladderLength : " + res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
