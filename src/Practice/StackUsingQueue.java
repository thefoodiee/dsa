package Practice;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    static void main() {
        MyStack2 stack2 = new MyStack2();
        stack2.push(1);
        stack2.push(2);
        System.out.println(stack2.top());
        System.out.println(stack2.pop());
        System.out.println(stack2.empty());
    }
}

class MyStack2{
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack2(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x){
        if(queue1.isEmpty()){
            queue1.add(x);
            return;
        }
        while(!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        queue1.add(x);
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
    }

    public int pop(){
        return queue1.isEmpty() ? -1 : queue1.poll();
    }

    public int top(){
        return queue1.isEmpty() ? -1 : queue1.peek();
    }

    public boolean empty(){
        return queue1.isEmpty();
    }
}