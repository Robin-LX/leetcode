package leetcode_321;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        //solution.maxSubsequence(new int[]{7, 9, 3, 2, 9, 0, 6, 1, 9}, 4);
        int[] arr1 = new int[]{3, 8, 5, 3, 4};
        int[] arr2 = new int[]{8, 7, 3, 6, 8};
        //System.out.println(Arrays.toString(solution.maxNumber(arr1, arr2, 5)));
        System.out.println(solution2.getMaxValue(new int[]{8, 5}, new int[]{8, 7, 8}));
    }
}

class Solution2 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int arr1Size = nums1.length;
        int arr2Size = nums2.length;
        int[] resArr = new int[k];
        int arr1Num, arr2Num;
        for (int i = 0; i <= k; i++) {
            arr1Num = i;
            arr2Num = k - i;
            if (arr1Num > arr1Size || arr2Num > arr2Size) {
                continue;
            }
            int[] getArr1 = maxSubsequence(nums1, arr1Num);
            System.out.println(Arrays.toString(getArr1));
            int[] getArr2 = maxSubsequence(nums2, arr2Num);
            System.out.println(Arrays.toString(getArr2));
            resArr = maxArr(getMaxValue(getArr1, getArr2), resArr);
        }

        return resArr;
    }

    public int[] maxArr(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > arr2[i]) return arr1;
            if (arr2[i] > arr1[i]) return arr2;
        }
        return arr1;
    }

    public int[] getMaxValue(int[] arr1, int[] arr2) {
        int arr1Idx = 0;
        int arr2Idx = 0;
        int[] resArr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length + arr2.length; i++) {
            if (arr1Idx == arr1.length) {
                resArr[i] = arr2[arr2Idx++];
                continue;
            }
            if (arr2Idx == arr2.length) {
                resArr[i] = arr1[arr1Idx++];
                continue;
            }
            int tmpArr1Idx = arr1Idx;
            int tmpArr2Idx = arr2Idx;
            if (arr1[arr1Idx] == arr2[arr2Idx]) {
                while (tmpArr1Idx < arr1.length && tmpArr2Idx < arr2.length && arr1[tmpArr1Idx] == arr2[tmpArr2Idx]) {
                    tmpArr1Idx++;
                    tmpArr2Idx++;
                }
                if (tmpArr2Idx == arr2.length || tmpArr1Idx == arr1.length) {
                    if (tmpArr1Idx < arr1.length) {
                        resArr[i] = arr1[arr1Idx++];
                        continue;
                    }
                    if (tmpArr2Idx < arr2.length) {
                        resArr[i] = arr2[arr2Idx++];
                        continue;
                    }
                    resArr[i] = arr1[arr1Idx];
                    arr1Idx++;
                    continue;
                }
                if (arr1[tmpArr1Idx] >= arr1[arr1Idx] && arr1[tmpArr1Idx] > arr2[tmpArr2Idx]) {
                    resArr[i] = arr1[arr1Idx++];
                    continue;
                }
                if (arr2[tmpArr2Idx] >= arr2[arr2Idx] && arr2[tmpArr2Idx] > arr1[tmpArr1Idx]) {
                    resArr[i] = arr2[arr2Idx++];
                    continue;
                }
                resArr[i] = arr1[arr1Idx];
                arr1Idx++;
            } else if (arr1[tmpArr1Idx] > arr2[tmpArr2Idx]) {
                resArr[i] = arr1[arr1Idx++];
            }else {
                resArr[i] = arr2[arr2Idx++];
            }
        }
        return resArr;
    }

    public int[] maxSubsequence(int[] arr, int n) {
        if (arr.length == 0) {
            return new int[0];
        }
        int[] res = new int[n];
        int maxNumIdx = -1;
        for (int i = 0; i < n; i++) {
            int maxNum = Integer.MIN_VALUE;
            for (int j = maxNumIdx + 1; j < arr.length - n + i + 1; j++) {
                if (arr[j] > maxNum) {
                    maxNum = arr[j];
                    maxNumIdx = j;
                }
            }
            res[i] = maxNum;
        }
        return res;
    }
}
