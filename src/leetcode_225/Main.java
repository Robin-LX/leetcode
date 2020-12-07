package leetcode_225;

//leetcode #225

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(9);
        System.out.println(myStack.top());
        System.out.println(myStack.empty());
        myStack.pop();
        System.out.println(myStack.top());
        myStack.pop();
        System.out.println(myStack.empty());
    }
}

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        //queue2将地址赋给queue1，用下方的代码将导致queue1与queue2指向同一内存地址！！！
        /*while (!queue2.isEmpty()) {
            queue2.poll();
        }*/
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return  queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */