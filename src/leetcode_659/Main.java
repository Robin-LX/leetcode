package leetcode_659;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int ele : nums) {
            if (!map.containsKey(ele)) {
                map.put(ele, new PriorityQueue<Integer>());
            }
            if (map.containsKey(ele - 1)) {
                int preLength = map.get(ele - 1).poll();
                map.get(ele).offer(preLength + 1);
                if (map.get(ele - 1).isEmpty()) {
                    map.remove(ele - 1);
                }
            } else {
                map.get(ele).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            if (entry.getValue().peek() < 3) {
                return false;
            }
        }

        return true;
    }
}
