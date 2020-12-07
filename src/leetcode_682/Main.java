package leetcode_682;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] ops = {"5","2","C","D","+"};
        System.out.println(s.calPoints(ops));
    }
}

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        int a, b, c;

        for (String s : ops) {
            switch (s){
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    c = a + b;
                    stack.push(b);
                    stack.push(a);
                    stack.push(c);
                    break;
                case "D":
                    a = stack.pop();
                    b = 2 * a;
                    stack.push(a);
                    stack.push(b);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }

        int result = 0;
        int size = stack.size();

        for (int i = 0; i < size; i++) {
            result += stack.pop();
        }
        return result;
    }
}