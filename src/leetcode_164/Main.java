package leetcode_164;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        if (min == max) return 0;

        int[] minBucket = new int[nums.length - 1];
        int[] maxBucket = new int[nums.length - 1];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        int interval = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min || nums[i] == max) continue;
            int index = (nums[i] - min) / interval;
            minBucket[index] = Math.min(minBucket[index], nums[i]);
            maxBucket[index] = Math.max(maxBucket[index], nums[i]);
        }

        int maxGap = 0;
        int preValue = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (minBucket[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, minBucket[i] - preValue);
            preValue = maxBucket[i];
        }

        maxGap = Math.max(max - preValue, maxGap);
        return maxGap;
    }
}
