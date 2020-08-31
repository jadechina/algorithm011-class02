//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法 
// 👍 207 👎 0

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution0701 {

    private static final int R    = 26;
    int[][]                  dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    static class TrieNode {
        private TrieNode[] next;
        private String     word;

        public TrieNode() {
            this.next = new TrieNode[R];
            this.word = null;
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode curr = this;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if (curr.next[index] == null) {
                    curr.next[index] = new TrieNode();
                }
                curr = curr.next[index];
            }
            curr.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return res;
        }
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(res, i, j, board, root);
            }
        }
        return res;
    }

    private void dfs(List<String> res, int i, int j, char[][] board, TrieNode root) {
        char c = board[i][j];
        int index = c - 'a';
        TrieNode curr = root.next[index];
        if (curr != null && curr.word != null) {
            res.add(curr.word);
            curr.word = null;
        }
        board[i][j] = '#';
        int m = board.length;
        int n = board[0].length;
        for (int k = 0; k < 4; k++) {
            int nextI = i + dirs[k][0];
            int nextJ = j + dirs[k][1];
            if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n || board[nextI][nextJ] == '#') {
                continue;
            }
            if (curr != null) {
                dfs(res, nextI, nextJ, board, curr);
            }
        }
        board[i][j] = c;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
