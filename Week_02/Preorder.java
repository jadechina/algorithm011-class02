
/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * @author tao.shen
 * @version : Preorder, v1.0 2020年07月05日 02:12 tao.shen Exp $
 */
public class Preorder {

    public List<Integer> preorder(Solution.Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Solution.Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Solution.Node node : root.children) {
            helper(node, res);
        }
    }

    // Definition for a Node.
    class Node {
        public int                 val;
        public List<Solution.Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Solution.Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
