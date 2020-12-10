package leetcode_53;

public class Main {
    public static void main(String[] args) {

    }
}

/*
    动态规划解法
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}

/*
    分治算法
 */

