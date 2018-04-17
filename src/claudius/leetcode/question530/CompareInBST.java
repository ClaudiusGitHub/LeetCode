package claudius.leetcode.question530;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * <p>
 * 给定一个二叉排序树，选出任意两个节点的最小绝对差值。
 * 本题重在理解二叉排序树中遍历规律。二叉排序树中序遍历即从小到大进行遍历。然后进行中序遍历，然后比较当前值与上一个值的差值
 */
public class CompareInBST {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        getMinimumDifference(root.left);       //左结点

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;                       //当前值进行赋值

        getMinimumDifference(root.right);

        return min;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}