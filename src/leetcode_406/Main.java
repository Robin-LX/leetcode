package leetcode_406;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        for (int[] element : solution.reconstructQueue(arr)) {
            System.out.printf(Arrays.toString(element));
        }
        solution.reconstructQueue(arr);
    }
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        //排序后的结果是：[4, 4][5, 2][5, 0][6, 1][7, 1][7, 0]
        //之所以[5, 2]比[5, 0]先排序，是因为[5, 2]中，两个空位必然有一个是属于[5, 0],如果先排了[5, 0]，那么[5, 2]就会多一个位置，从而变为[5, 3]

        int[][] res = new int[people.length][];
        for (int i = 0; i < people.length; i++) {
            int space = people[i][1] + 1;
            int spaceCount = 0;
            for (int j = 0; j < people.length; j++) {
                if (res[j] == null) {
                    spaceCount++;
                }
                if (spaceCount == space) {
                    res[j] = people[i];
                    break;
                }
            }
        }

        return res;
    }
}