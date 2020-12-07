package leetcode_861;

public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        };
        Solution solution = new Solution();
        System.out.println(solution.matrixScore(arr));
    }
}

class Solution {
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = (A[i][j] + 1) % 2;
                }
            }
        }
        int res = A.length * (1 << (A[0].length - 1));
        for (int i = 1; i < A[0].length; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] == 1) count++;
            }
            res += Math.max(count, A.length - count) * (1 << (A[0].length - 1 - i));
        }

        return res;
    }
}