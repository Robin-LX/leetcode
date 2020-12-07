package leetcode_100;

//第一次完全自己写出来一遍通过！！！
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        boolean leftIsSame = false;
        boolean rightIsSame = false;
        if (p != null && q != null) {
            if (p.val == q.val) {
                if (isSameTree(p.left, q.left)) {
                    leftIsSame = true;
                }
                if (isSameTree(p.right, q.right)) {
                    rightIsSame = true;
                }
            }

            return leftIsSame && rightIsSame;
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