
/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author tao.shen
 * @version : Solution, v1.0 2020年07月04日 22:10 tao.shen Exp $
 */
public class Solution {

    /**
     * 给定一个二叉树，返回它的中序 遍历。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }
        return res;
    }

    /**
     * 给定一个二叉树，返回它的 前序 遍历。
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.left != null) {
            helper(root.left, res);
        }
        if (root.right != null) {
            helper(root.right, res);
        }
    }

    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            res.add(current.val);
            Collections.reverse(current.children);
            for (Node node : current.children) {
                stack.push(node);
            }
        }
        return res;
    }

    // Definition for a Node.
    class Node {
        public int        val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
