package leetcode_190;
/*
    主要的思路是不能把n当做十进制的数来处理，要当做二进制来处理。
 */

public class Main {
    public static void main(String[] args) {
        //Solution solution = new Solution();

        String unSignedInt = Integer.toUnsignedString(0b11111111111111111111111111111101);
        System.out.println(unSignedInt);

        System.out.println(0b11111111111111111111111111111101);

    }
}

class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n = n >> 1;
        }
        return res;
    }
}
