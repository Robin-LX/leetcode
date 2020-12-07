package leetcode_226;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmpNode = null;
        tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        return root;
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


