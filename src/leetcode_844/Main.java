package leetcode_844;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String S = "ab#c";
        String T = "ad#c";
        System.out.println(s.backspaceCompare(S, T));
    }
}

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return dealProblem(S).equals(dealProblem(T));
    }

    public String dealProblem(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '#' :
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(String.valueOf(s.charAt(i)));
                    break;
            }
        }

        int size = stack.size();
        String result = "";

        for (int i = 0; i < size; i++) {
            result += stack.pop();
        }

        return result;
    }
}