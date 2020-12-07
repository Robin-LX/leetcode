package leetcode_1589;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        for (String s : logs) {
            if (s.startsWith("..")) {
                if (count > 0) {
                    count--;
                }
            } else if (s.startsWith("./")) {

            } else {
                count++;
            }
        }

        return count;
    }
}
