package leetcode_222;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(null, null), new TreeNode(null, null)), new TreeNode(new TreeNode(null, null), null));
        System.out.println(solution.countNodes(root));
    }
}

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
            level++;
        }

        int low = 1 << level;
        int high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean exists(TreeNode root, int level, int mid) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & mid) > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
            bits >>= 1;
        }

        return node != null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}