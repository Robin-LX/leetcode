package leetcode_20;

//leetcode #20

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().isValid("({[]})"));
    }

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char chPeek = stack.peek();
                    if ((ch == ')' && chPeek == '(') || (ch == '}' && chPeek == '{') || (ch == ']' && chPeek == '[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
