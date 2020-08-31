//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 505 👎 0

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution0806 {

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return null;
        }
        this.qn = n;
        rows = new int[qn];
        pies = new int[4 * qn - 1];
        nas = new int[2 * qn - 1];
        queens = new int[qn];
        backtrack(0);
        return res;
    }

    List<List<String>> res = new ArrayList<>();
    private int        qn;
    private int[]      rows;
    private int[]      pies;
    private int[]      nas;
    private int[]      queens;

    private void backtrack(int row) {
        for (int col = 0; col < qn; col++) {
            if (isDone(row, col)) {
                palceQueen(row, col);
                if (row + 1 == qn) {
                    addToRes();
                } else {
                    backtrack(row + 1);
                }
                removeQueen(row, col);
            }
        }
    }

    private boolean isDone(int row, int col) {
        int res = rows[col] + pies[row - col + 2 * qn] + nas[row + col];
        return res == 0;
    }

    private void palceQueen(int row, int col) {
        queens[row] = col;
        rows[col] = 1;
        pies[row - col + 2 * qn] = 1;
        nas[row + col] = 1;
    }

    private void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        pies[row - col + 2 * qn] = 0;
        nas[row + col] = 0;
    }

    private void addToRes() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < qn; i++) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++) {
                sb.append(".");
            }
            sb.append("Q");
            for (int j = 0; j < qn - col - 1; j++) {
                sb.append(".");
            }
            list.add(sb.toString());
        }
        res.add(list);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
