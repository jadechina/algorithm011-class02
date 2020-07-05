
/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */

import java.util.List;

/**
 * @author tao.shen
 * @version : Node, v1.0 2020年07月05日 17:06 tao.shen Exp $
 */
public class Node {

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
