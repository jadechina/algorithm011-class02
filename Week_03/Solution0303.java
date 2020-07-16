
/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author tao.shen
 * @version : Solution0303, v1.0 2020年07月12日 12:31 tao.shen Exp $
 */
public class Solution0303 {

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     */
    public List<List<Integer>> combine(int n, int k) {
        if (k < 1 || n < k) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(1, n, k, new Stack<>(), res);
        return res;
    }

    private void helper(int index, int n, int k, Stack<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i <= n - (k - curr.size()) + 1; i++) {
            curr.push(i);
            helper(i + 1, n, k, curr, res);
            curr.pop();
        }
    }

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    TreeNode res = null;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lSon = dfs(root.left, p, q);
        boolean rSon = dfs(root.right, p, q);
        if ((lSon && rSon) || ((root.val == p.val || root.val == q.val) && (lSon || rSon))) {
            res = root;
        }
        return lSon || rSon || (root.val == p.val || root.val == q.val);
    }

    public static void main(String[] args) {
        new Solution0303().combine(4, 2);
    }

}
