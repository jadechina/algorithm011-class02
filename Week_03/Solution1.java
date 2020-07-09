
/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author tao.shen
 * @version : Solution1, v1.0 2020年07月09日 23:13 tao.shen Exp $
 */
public class Solution1 {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(0, 0, n, "", res);
        return res;
    }

    public void helper(int left, int right, int n, String s, List<String> res) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left < n) {
            helper(left + 1, right, n, s + "(", res);
        }
        if (left > right) {
            helper(left, right + 1, n, s + ")", res);
        }
    }

}
