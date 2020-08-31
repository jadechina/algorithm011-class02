//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 488 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution0703 {

    int      n        = 3;
    int      len      = n * n;
    char[][] board;
    int[][]  rows     = new int[len][len + 1];
    int[][]  cols     = new int[len][len + 1];
    int[][]  boxes    = new int[len][len + 1];
    boolean  isSolved = false;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int v = Character.getNumericValue(c);
                    placeNumber(i, j, v);
                }
            }
        }
        backtrack(0, 0);
    }

    private void backtrack(int row, int col) {
        if (board[row][col] == '.') {
            for (int i = 1; i < 10; i++) {
                if (couldPlace(row, col, i)) {
                    placeNumber(row, col, i);
                    placeNextNumber(row, col);
                    if (!isSolved) {
                        removeNumber(row, col, i);
                    }
                }
            }
        } else {
            placeNextNumber(row, col);
        }
    }

    private boolean couldPlace(int row, int col, int v) {
        int index = (row / n) * n + col / n;
        return rows[row][v] + cols[col][v] + boxes[index][v] == 0;
    }

    private void placeNumber(int row, int col, int v) {
        int index = (row / n) * n + col / n;
        rows[row][v]++;
        cols[col][v]++;
        boxes[index][v]++;
        board[row][col] = (char) (v + '0');
    }

    private void removeNumber(int row, int col, int v) {
        int index = (row / n) * n + col / n;
        rows[row][v]--;
        cols[col][v]--;
        boxes[index][v]--;
        board[row][col] = '.';
    }

    private void placeNextNumber(int row, int col) {
        if (row == len - 1 && col == len - 1) {
            isSolved = true;
        } else {
            if (col == len - 1) {
                backtrack(row + 1, 0);
            } else {
                backtrack(row, col + 1);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
