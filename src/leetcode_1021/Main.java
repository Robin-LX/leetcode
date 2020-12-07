package leetcode_1021;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeOuterParentheses("(()())(())(()(()))"));
    }
}

class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        List<String> ls = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            sb.append(ch);
            if (ch == '(') {
                stack.push(ch);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    ls.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
        }

        String result = "";

        for (String s : ls) {
            result += s.substring(1, s.length() - 1);
        }

        return result;
    }
}