package leetcode_1370;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortString("aaaabbbbcccc"));
    }
}

class Solution {
    public String sortString(String s) {
        boolean[] isVisited = new boolean[s.length()];
        StringBuilder res = new StringBuilder();
        int visitCount = 0;

        while (visitCount != s.length()) {
            char minChar = 'a' - 1;
            char maxChar = 'z' + 1;
            boolean isFinished = false;
            int minIdx = -1;
            while (!isFinished) {
                for (int i = 0; i < s.length(); i++) {
                    if (isVisited[i] == true) continue;
                    char ch = s.charAt(i);
                    if (ch > minChar && ch < maxChar) {
                        maxChar = ch;
                        minIdx = i;
                    }
                }
                if (maxChar == 'z' + 1) {
                    isFinished = true;
                } else {
                    res.append(maxChar);
                    isVisited[minIdx] = true;
                    visitCount++;
                    minChar = maxChar;
                    maxChar = 'z' + 1;
                }
            }

            minChar = 'a' - 1;
            maxChar = 'z' + 1;
            isFinished = false;
            int maxIdx = -1;
            while (!isFinished) {
                for (int i = 0; i < s.length(); i++) {
                    if (isVisited[i] == true) continue;
                    char ch = s.charAt(i);
                    if (ch > minChar && ch < maxChar) {
                        minChar = ch;
                        maxIdx = i;
                    }
                }
                if (minChar == 'a' - 1) {
                    isFinished = true;
                } else {
                    res.append(minChar);
                    isVisited[maxIdx] = true;
                    visitCount++;
                    maxChar = minChar;
                    minChar = 'a' - 1;
                }
            }
        }

        return res.toString();
    }
}
