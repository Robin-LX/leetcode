package leetcode_649;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.predictPartyVictory("RD");
    }
}

class Solution {
    public String predictPartyVictory(String senate) {
        int countR = 0, countD = 0;
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                countR++;
            } else {
                countD++;
            }
        }

        int index = 0;
        int tmpIdx = (index + 1) % senate.length();
        boolean[] isAlive = new boolean[senate.length()];
        Arrays.fill(isAlive, true);
        while (countD != 0 && countR != 0) {
            while (!isAlive[tmpIdx] || senate.charAt(index) == senate.charAt(tmpIdx)) {
                tmpIdx = (tmpIdx + 1) % senate.length();
            }

            isAlive[tmpIdx] = false;
            if (senate.charAt(tmpIdx) == 'R') countR--;
            else countD--;

            index = (index + 1) % senate.length();
            while (!isAlive[index]) {
                index = (index + 1) % senate.length();
            }
            tmpIdx = (index + 1) % senate.length();
        }
        if (countR == 0) return "Dire";
        else return "Radiant";
    }
}

class solution2 {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
}
