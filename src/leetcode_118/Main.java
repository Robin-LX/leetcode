package leetcode_118;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> array = solution.generate(5);
        for (List<Integer> arr : array) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<Integer> curArr = new ArrayList<>();
        List<Integer> preArr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        preArr.add(1);
        res.add(preArr);
        for (int i = 2; i <= numRows; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    curArr.add(1);
                } else {
                    curArr.add(preArr.get(j - 1) + preArr.get(j));
                }
            }
            res.add(curArr);
            preArr = curArr;
            curArr = new ArrayList<>();
        }

        return res;
    }
}