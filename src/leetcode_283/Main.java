package leetcode_283;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.moveZeroes(new int[] {0,1,0,3,12});
    }
}

/*
class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 1; i <= nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i ; j++) {
                if (nums[j] == 0) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
            }
        }
    }
}*/

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }

        //System.out.println(Arrays.toString(nums));
    }
}
