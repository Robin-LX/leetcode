package leetcode_376;

public class Main {
}

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int res = 1;//默认最右面有一个峰值
        String dir = "equal"; //应该记录的是趋势而不是前一个的差值
        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] - nums[i] > 0) {
                if (!dir.equals("up")) {
                    res++;
                    dir = "up";
                }
            }
            if (nums[i + 1] - nums[i] < 0) {
                if (!dir.equals("down")) {
                    res++;
                    dir = "down";
                }
            }
        }
        return res;
    }
}