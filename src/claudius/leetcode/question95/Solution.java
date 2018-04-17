package claudius.leetcode.question95;


import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数n，返回1-n个整数序列所能生成的所有二叉搜索树的头结点的链表
 * <p>
 * 思路：依次选择每个值为头结点，然后左侧的序列作为左子树，右侧序列作为右子树，然后递归生成
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List list = solution.generateTrees(4);
        System.out.println(list.size());
    }

    /**
     * 生成调用函数
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<TreeNode>();

        return generateTrees(1, n);
    }

    /**
     * 递归生成函数
     *
     * @param begin
     * @param end
     * @return
     */
    public List<TreeNode> generateTrees(int begin, int end) {
        if (begin > end)
            return null;
        List<TreeNode> roots = new LinkedList<>();
        if (begin == end) {
            roots.add(new TreeNode(begin));
            return roots;
        }
        for (int i = begin; i <= end; i++) {
            List<TreeNode> leftSonList = generateTrees(begin, i - 1);
            List<TreeNode> rightSonList = generateTrees(i + 1, end);

            if (leftSonList != null && rightSonList != null) {
                for (TreeNode leftNode : leftSonList) {
                    for (TreeNode rightNode : rightSonList) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        roots.add(root);
                    }
                }
            } else if (leftSonList != null) {
                for (TreeNode leftNode : leftSonList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    roots.add(root);
                }
            } else if (rightSonList != null) {
                for (TreeNode rightNode : rightSonList) {
                    TreeNode root = new TreeNode(i);
                    root.right = rightNode;
                    roots.add(root);
                }
            }
        }
        return roots;
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