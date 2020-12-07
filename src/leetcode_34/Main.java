package leetcode_34;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(solution.binarySearch(arr, 7, false));
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int minIdx = binarySearch(nums, target, true);
        int maxIdx = binarySearch(nums, target, false);

        return new int[]{minIdx, maxIdx};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            if (lower) {
                mid = (left + right) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                    continue;
                } else {
                    right = mid;
                    continue;
                }
            } else {
                double tmpMid = (left + right) / 2.0;
                mid = (int) Math.ceil(tmpMid);
                if (nums[mid] > target) {
                    right = mid - 1;
                    continue;
                } else {
                    left = mid;
                    continue;
                }
            }
        }

        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
