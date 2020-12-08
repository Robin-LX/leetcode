package leetcode_842;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.splitIntoFibonacci("0123");
    }
}

class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        backtrack(S.toCharArray(), res, 0);
        return res;
    }

    private boolean backtrack(char[] nums, List<Integer> res, int index) {
        if (index == nums.length && res.size() >= 3) {
            return true;
        }
        for (int i = index; i < nums.length; i++) {
            //防止截取的过长
            if (i - index + 1 > 10) {
                break;
            }
            //防止两位以上的数以0开始
            if (nums[index] == '0' && i > index) {
                break;
            }
            //截取数字，判断是否大于最大的int类型
            long subNum = subNums(nums, index, i);
            if (subNum > Integer.MAX_VALUE) {
                break;
            }

            int resSize = res.size();
            if (resSize >= 2 && subNum > (res.get(resSize - 1) + res.get(resSize - 2))) {
                break;
            }
            if (resSize < 2 || subNum == (res.get(resSize - 1) + res.get(resSize - 2))) {
                res.add((int) subNum);
                if (backtrack(nums, res, i + 1)) return true;
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    private long subNums(char[] nums, int startIdx, int endIdx) {
        long value = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            value = value * 10 + nums[i] - '0';
        }
        return value;
    }
}