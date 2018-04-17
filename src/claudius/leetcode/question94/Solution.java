package claudius.leetcode.question94;

import java.util.LinkedList;
import java.util.List;

/**
 * 遍历二叉树
 */
public class Solution {
    private List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        traverse(root);
        return list;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        list.add(node.val);
        traverse(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
