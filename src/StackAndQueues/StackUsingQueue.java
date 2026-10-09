package StackAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    static void main() {
        MyStack3 stack = new MyStack3();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        stack.pop();
        stack.pop();
        System.out.println(stack.empty());
    }
}

class MyStack2 {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack2() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        q1.add(x);
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

class MyStack3 {
    Queue<Integer> queue;
    public MyStack3() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        if(queue.isEmpty()){
            queue.add(x);
            return;
        }
        queue.add(x);
        for(int i = 0; i<queue.size()-1; i++){
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.isEmpty() ? -1 : queue.poll();
    }

    public int top() {
        return queue.isEmpty() ? -1 : queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}