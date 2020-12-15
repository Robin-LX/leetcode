package leetcode_738;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.monotoneIncreasingDigits(102);
    }
}

class Solution {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        }
        List<Integer> arr = new ArrayList<>();
        int tens = 10;
        int res = 0;
        while (N > 0) {
            arr.add(N % tens);
            N = N / 10;
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) < arr.get(j)) {
                    for (int k = 0; k < j; k++) {
                        arr.set(k, 9);
                    }
                    arr.set(j, arr.get(j) - 1);
                    i = j - 1;
                    break;
                }
            }
        }

        tens = 1;
        for (Integer i : arr) {
            res += tens * i;
            tens *= 10;
        }
        System.out.println(res);
        return res;
    }
}