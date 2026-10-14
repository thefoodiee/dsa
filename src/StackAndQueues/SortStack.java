package StackAndQueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SortStack {
    static void main() {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(2);
        stack.push(32);
        stack.push(3);
        stack.push(41);
        sort(stack);
        System.out.println(stack);
    }
    static void sort(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }

        int num = stack.peek();
        stack.pop();

        sort(stack);

        sortedInsert(stack, num);
    }

    static void sortedInsert(Stack<Integer> stack, int num){
        if(stack.isEmpty() || (stack.peek() < num)){
            stack.push(num);
            return;
        }
        int n = stack.peek();
        stack.pop();

        sortedInsert(stack, num);

        stack.push(n);
    }
}
