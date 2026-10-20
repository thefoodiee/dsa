package Practice;

public class StackUsingArray {
    static void main() {
        MyStack stack = new MyStack(1);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.isEmpty());
        System.out.println(stack.isEmpty());
        stack.pop();
    }
}

class MyStack{
    int[] arr;
    int idx;
    public MyStack(int n) {
        // Define Data Structures
        arr = new int[n];
        idx = -1;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return idx == -1;
    }

    public boolean isFull() {
        // check if the stack is full
        return idx == arr.length-1;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(idx+1 == arr.length) return;
        idx++;
        arr[idx] = x;
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(idx == -1) return;
        idx--;
    }

    public int peek() {
        // Returns the top element of the stack
        if(idx == -1) return -1;
        return arr[idx];
    }
}
