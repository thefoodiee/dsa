package Practice;

import java.util.Stack;

public class QueueUsingStack {
    static void main() {
        MyQueue2 q2 = new MyQueue2();
        q2.push(1);
        q2.push(2);
        System.out.println(q2.peek());
        System.out.println(q2.pop());
        System.out.println(q2.empty());
    }
}

class MyQueue2{
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue2(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x){
        s1.push(x);
    }

    public int pop(){
        if(!s2.isEmpty()) return s2.pop();
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public int peek(){
        if(!s2.isEmpty()) return s2.peek();
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    public boolean empty(){
        return s1.isEmpty() && s2.isEmpty();
    }
}
