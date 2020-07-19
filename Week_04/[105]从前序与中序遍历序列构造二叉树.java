//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 571 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution0402 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n <= 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, map, 0, n - 1, 0, n - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, Map<Integer, Integer> map, int pLeft,
                            int pRight, int iLeft, int iRight) {
        if (pLeft > pRight) {
            return null;
        }
        int iRoot = map.get(preorder[pLeft]);
        TreeNode root = new TreeNode(preorder[pLeft]);
        int iLeftNums = iRoot - iLeft;
        root.left = helper(preorder, inorder, map, pLeft + 1, pLeft + iLeftNums, iLeft, iRoot - 1);
        root.right = helper(preorder, inorder, map, pLeft + iLeftNums + 1, pRight, iRoot + 1,
            iRight);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
