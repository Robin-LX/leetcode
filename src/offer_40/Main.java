package offer_40;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = solution.getLeastNumbers(new int[] {0, 0, 0, 2, 0, 5}, 0);
        System.out.println(Arrays.toString(arr));
    }
}

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : arr) {
            queue.offer(num);
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}