
/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tao.shen
 * @version : Solution0302, v1.0 2020年07月10日 23:31 tao.shen Exp $
 */
public class Solution0302 {

    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void helper(int index, int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        helper(index + 1, nums, list, res);
        list.add(nums[index]);
        helper(index + 1, nums, list, res);
        list.remove(list.size() - 1);
    }

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<String, String> map = new HashMap<String, String>() {
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }
        };
        serach(0, "", digits, map, res);
        return res;
    }

    private void serach(int index, String s, String digits, Map<String, String> map,
                        List<String> res) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        String letters = map.get(Character.toString(digits.charAt(index)));
        for (int i = 0; i < letters.length(); i++) {
            serach(index + 1, s + letters.charAt(i), digits, map, res);
        }
    }

    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     */
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return null;
        }
        this.qn = n;
        this.rows = new int[qn];
        this.pies = new int[4 * qn - 1];
        this.nas = new int[2 * qn - 1];
        this.queens = new int[qn];
        backtrack(0);
        return this.res;
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

    public static void main(String[] args) {
        List<List<String>> res = new Solution0302().solveNQueens(8);
        for (List<String> re : res) {
            for (String s : re) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

}
