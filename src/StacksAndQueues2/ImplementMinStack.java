package StacksAndQueues2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ImplementMinStack {
    static void main() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}

class MinStack{
    Stack<List<Integer>> stack;
    MinStack(){
        stack = new Stack<>();
    }

    void push(int value){
        if(stack.isEmpty()){
            stack.push(new ArrayList<>(Arrays.asList(value, value)));
        }
        else{
            int min = Math.min(value, stack.peek().get(1));
            stack.push(new ArrayList<>(Arrays.asList(value, min)));
        }
    }

    void pop(){
        stack.pop();
    }

    int top(){
        return stack.peek().getFirst();
    }

    int getMin(){
        return stack.peek().get(1);
    }
}