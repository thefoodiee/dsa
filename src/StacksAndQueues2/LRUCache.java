package StacksAndQueues2;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static void main() {

    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class Cache{
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    Cache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insertAtHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insertAtHead(node);
            return node.val;
        }
        return -1;
    }

    void put(int key, int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insertAtHead(node);
            return;
        }

        if(map.size() == capacity){
            Node node = tail.prev;
            map.remove(node.key);
            remove(node);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insertAtHead(node);
    }
}