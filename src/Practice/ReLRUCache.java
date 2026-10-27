package Practice;

import java.util.HashMap;
import java.util.Map;

public class ReLRUCache {
    static void main() {

    }
}

class ReNode{
    int key;
    int val;
    ReNode prev;
    ReNode next;
    ReNode(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class ReCache{
    int capacity;
    ReNode head;
    ReNode tail;
    Map<Integer, ReNode> map;
    ReCache(int capacity){
        this.capacity = capacity;
        this.head = new ReNode(-1, -1);
        this.tail = new ReNode(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
        this.map = new HashMap<>();
    }

    void remove(ReNode node){
        //remove before tail
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    void insert(ReNode node){
        // insert after head
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    int get(int key){
        if(!map.containsKey(key)) return -1;

        ReNode node = map.get(key);

        remove(node);
        insert(node);

        return node.val;
    }

    void put(int key, int val){
        if(map.containsKey(key)){
            ReNode node = map.get(key);
            node.val = val;
            remove(node);
            insert(node);
            return;
        }

        if(map.size() == capacity){
            ReNode node = tail.prev;
            map.remove(node.key);
            remove(node);
        }

        ReNode node = new ReNode(key, val);
        map.put(key, node);
        insert(node);
    }
}