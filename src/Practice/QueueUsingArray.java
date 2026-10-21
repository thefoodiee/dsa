package Practice;

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

        MyQueue q = new MyQueue(2);
        System.out.println(q.isEmpty());
        System.out.println(q.getRear());
        q.enqueue(3);
        q.enqueue(7);
        System.out.println(q.isFull());

//        MyQueue q = new MyQueue(2);
//        System.out.println(q.isEmpty());
//        System.out.println(q.getRear());
//        q.enqueue(5);
//        q.enqueue(6);
//        q.dequeue();
//        q.dequeue();
//        q.enqueue(10);
//        System.out.println(q.isFull());
    }
}

class MyQueue{
    int[] arr;
    int front;
    int back;
    // Constructor
    public MyQueue(int n) {
        // Define Data Structures
        arr = new int[n];
        front = -1;
        back = -1;
    }

    public boolean isEmpty() {
        // Check if queue is empty
        return front == -1 || front>back;
    }

    public boolean isFull() {
        // Check if queue is full
        return front == 0 && back == arr.length-1;
    }

    public void enqueue(int x) {
        // Enqueue
        if(back+1 == arr.length) return;
        if(front == -1) front++;
        back++;
        arr[back] = x;
    }

    public void dequeue() {
        // Dequeue
        if(isEmpty()) return;
        front++;
        if(front > back){
            front = -1;
            back = -1;
        }
    }

    public int getFront() {
        // Get front element
        if(isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
        // Get last element
        if(isEmpty()) return -1;
        return arr[back];
    }
}
