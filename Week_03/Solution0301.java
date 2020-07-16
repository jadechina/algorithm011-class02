
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
public class Solution0301 {

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

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double halfRes = helper(x, n / 2);
        return n % 2 == 0 ? halfRes * halfRes : halfRes * halfRes * x;
    }

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

}
