package leetcode_1046;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeight(new int[] {2, 7, 4, 1, 8, 1}));
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : stones){
            queue.add(num);
        }

        while (!(queue.size() < 2)) {
            int stoneA = queue.poll();
            int stoneB = queue.poll();
            if (stoneA != stoneB) {
                queue.add(Math.abs(stoneA - stoneB));
            }
        }

        if (queue.size() == 0) {
            return 0;
        }
        return queue.peek();
    }
}