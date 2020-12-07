package leetcode_31;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nextPermutation(new int[] {1, 3, 2});
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        int value = 0;
        int indexHead = -1;
        int indexEnd = -1;
        int maxIndexHead = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0 ; i--) {
            value = nums[i];
            for (int j = i - 1; j >= 0 ; j--) {
                if (nums[j] < value && j > maxIndexHead) {
                    indexEnd = i;
                    indexHead = j;
                    maxIndexHead = j;
                }
            }
        }

        if (indexHead == -1) {
            Arrays.sort(nums);
        } else {
            int temp = nums[indexEnd];
            nums[indexEnd] = nums[indexHead];
            nums[indexHead] = temp;
            Arrays.sort(nums, indexHead + 1, nums.length);
        }

        System.out.println(Arrays.toString(nums));
    }
}