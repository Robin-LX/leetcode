package leetcode_217;

import java.util.HashSet;
import java.util.Set;

public class Main {
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int i : nums) {
            if (!hs.add(i)) return true;
        }
        return false;
    }
}