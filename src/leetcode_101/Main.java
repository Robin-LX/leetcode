package leetcode_101;


public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }

        if (leftTree != null && rightTree != null) {
            boolean isLeftSame = false;
            boolean isRightSame = false;
            if (leftTree.val == rightTree.val) {
                if (check(leftTree.left, rightTree.right)) {
                    isLeftSame = true;
                }
                if (check(leftTree.right, rightTree.left)) {
                    isRightSame = true;
                }
            }

            return isLeftSame && isRightSame;
        }

        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}