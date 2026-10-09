package StackAndQueues;

public class StackUsingArray {
    static void main() {
        MyStack stack = new MyStack(3);
        stack.push(5);
        stack.push(3);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
    }
}

class MyStack{
    int top = -1;
    int[] arr;
    public MyStack(int n) {
        // Define Data Structures
        arr = new int[n];
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return top == -1;
    }

    public boolean isFull() {
        // check if the stack is full
        return top == arr.length-1;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(isFull()) return;
        top++;
        arr[top] = x;
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(isEmpty()) return;
        top--;
    }

    public int peek() {
        // Returns the top element of the stack
        if(isEmpty()) return -1;
        return arr[top];
    }
}
