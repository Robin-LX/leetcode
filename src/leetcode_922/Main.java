package leetcode_922;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] array = new int[A.length];
        int evenIdx = 0;
        int oddIdx = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                array[evenIdx] = A[i];
                evenIdx += 2;
            } else {
                array[oddIdx] = A[i];
                oddIdx += 2;
            }
        }

        return array;
    }
}