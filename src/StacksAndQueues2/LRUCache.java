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
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    Cache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    void insert(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.val;
    }

    void put(int key, int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
            return;
        }

        if(map.size() == capacity){
            Node node = tail.prev;
            map.remove(node.key);
            remove(node);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);
    }
}