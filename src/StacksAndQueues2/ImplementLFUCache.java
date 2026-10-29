package StacksAndQueues2;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class ImplementLFUCache {
    static void main() {

    }
}

class DLL{

}


class LFUCache{
    HashMap<Integer, Integer> cache = new HashMap<>();
    HashMap<Integer, Integer> keyCount = new HashMap<>();
    HashMap<Integer, LinkedHashSet<Integer>> freqMap = new HashMap<>();
    int capacity;
    int min = -1;

    LFUCache(int capacity){
        this.capacity = capacity;
        freqMap.put(1, new LinkedHashSet<>());
    }

    int get(int key){
        if (!cache.containsKey(key)) return -1;

        else{
            int count = keyCount.get(key);
            keyCount.put(key, count+1);
            freqMap.get(key).remove(key);
            if(count == min && freqMap.get(count).isEmpty()) min++;
            if(!freqMap.containsKey(count+1)) freqMap.put(count+1, new LinkedHashSet<>());
            freqMap.get(count+1).add(key);
            return cache.get(key);
        }
    }

    void put(int key, int value){
        if (capacity <= 0) return;
        if (cache.containsKey(key)){
            cache.put(key, value);
            get(key);
            return;
        }
        if (cache.size()>=capacity){
            int remove = freqMap.get(min).iterator().next();
            freqMap.get(min).remove(remove);
            cache.remove(remove);
            keyCount.remove(remove);
        }
        cache.put(key, value);
        keyCount.put(key, 1);
        min = 1;
        freqMap.get(1).add(key);
    }
}