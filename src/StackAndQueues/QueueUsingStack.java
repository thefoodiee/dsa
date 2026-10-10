package StackAndQueues;

import java.util.Stack;

public class QueueUsingStack {
    static void main() {
        MyQueue3 q = new MyQueue3();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}

class MyQueue2 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if(stack1.isEmpty()){
            stack1.push(x);
            return;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

class MyQueue3 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue3() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.add(x);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public int peek() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}