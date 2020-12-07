package leetcode_543;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDepth;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int Left = depth(node.left);
        int Right = depth(node.right);
        maxDepth = Math.max(Left + Right, maxDepth);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(Left, Right) + 1;//返回节点深度
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
