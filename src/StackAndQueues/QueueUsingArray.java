package StackAndQueues;

public class QueueUsingArray {
    static void main() {
//        MyQueue q = new MyQueue(3);
//        q.enqueue(5);
//        q.enqueue(3);
//        q.enqueue(4);
//        System.out.println(q.getFront());
//        q.dequeue();
//        System.out.println(q.isEmpty());
//        System.out.println(q.getRear());

//        MyQueue q = new MyQueue(2);
//        System.out.println(q.isEmpty());
//        System.out.println(q.getRear());
//        q.enqueue(3);
//        q.enqueue(7);
//        System.out.println(q.isFull());

        MyQueue q = new MyQueue(2);
//        System.out.println(q.isEmpty());
//        System.out.println(q.getRear());
        q.enqueue(5);
        q.enqueue(6);
        q.dequeue();
        q.dequeue();
        q.enqueue(10);
        System.out.println(q.isFull());
    }
}

class MyQueue{
    int[] arr;
    int f = -1, b = -1;
    public MyQueue(int n) {
        // Define Data Structures
        arr = new int[n];
    }

    public boolean isEmpty() {
        // Check if queue is empty
        return f == -1 || f > b;
    }

    public boolean isFull() {
        // Check if queue is full
        return b == arr.length-1 && f==0;
    }

    public void enqueue(int x) {
        // Enqueue
        if(isFull()) return;
        if(f == -1) f++;
        b++;
        arr[b] = x;
    }

    public void dequeue() {
        // Dequeue
        if(isEmpty()) return;
        f++;
        if(f>b){
            f = -1;
            b = -1;
        }
    }

    public int getFront() {
        // Get front element
        if(isEmpty()) return -1;
        return arr[f];
    }

    public int getRear() {
        // Get last element
        if(isEmpty()) return -1;
        return arr[b];
    }
}
