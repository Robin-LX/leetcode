package leetcode_1370;

public class Main2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.sortString("aaaabbbbcccc"));
    }
}

class Solution2 {
    public String sortString(String s) {
        StringBuilder res = new StringBuilder();

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 97]++;
        }

        int count = 0;
        int dir = 1;
        int idx = 0;
        while (count < s.length()) {
            if (idx == -1 || idx == 26) {
                idx += dir;
                continue;
            }
            if (arr[idx] > 0) {
                res.append((char)(97 + idx));
                arr[idx]--;
                count++;
            }
            idx += dir;
            if (idx  == 26) {
                dir = -1;
            }
            if (idx == -1) {
                dir = 1;
            }
        }

        return res.toString();
    }
}
