package leetcode_1047;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.removeDuplicates("abbaca");
        System.out.println(s);
    }
}

class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            } else {
                char temp = stack.peek();
                if (temp == ch) {
                    stack.pop();
                    continue;
                } else {
                    stack.push(ch);
                }
            }
        }

        String result = "";
        String tempResult = "";
        while (!stack.isEmpty()) {
            tempResult += stack.pop();
        }
        for (int i = 0; i < tempResult.length(); i++) {
            result += tempResult.charAt(tempResult.length() - 1 - i);
        }

        return result;
    }
}