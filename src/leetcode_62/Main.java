package leetcode_62;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.uniquePaths(19, 13));

    }
}

class Solution {
    //递归，会产生超时
    public int uniquePaths(int m, int n) {
        int[] res = new int[1];
        go(0, 0, res, m, n);
        return res[0];
    }

    private void go(int curX, int curY, int[] count, int desX, int desY) {
        if (curX == desX - 1 && curY == desY - 1) {
            count[0]++;
            return;
        }
        if (curX < desX - 1) {
            go(curX + 1, curY, count, desX, desY);
        }
        if (curY < desY - 1) {
            go(curX, curY + 1, count, desX, desY);
        }
    }
}

class Solution2 {
    //动态规划
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //第一列都是1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //第一行都是1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        //这里是递推公式
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m - 1][n - 1];
    }
}

class Solution3 {
    //动态规划优化
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int j = 1; j < n; j++)
            for (int i = 1; i < m; i++)
                dp[i] += dp[i - 1];
        return dp[m - 1];
    }
}