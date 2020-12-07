package leetcode_1441;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> s = solution.buildArray(new int[]{1, 2}, 4);
        for (String element :
                s) {
            System.out.println(element);
        }
    }
}

class Solution {
    public List<String> buildArray(int[] target, int n) {
        int[] flag = new int[n];
        int maxIndex = Integer.MIN_VALUE;
        for (int i = 0; i < target.length; i++) {
            flag[target[i] - 1] = 1;
            if (target[i] > maxIndex) {
                maxIndex = target[i];
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i < maxIndex) {
                if (flag[i] == 1) {
                    result.add("Push");
                } else {
                    result.add("Push");
                    result.add("Pop");
                }
            }
        }

        return result;
    }
}