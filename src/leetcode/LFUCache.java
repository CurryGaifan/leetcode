package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {

    private Map<Integer, Tuple> map;
    private TreeMap<Integer, Node> countMap = new TreeMap<>();
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap(capacity);
    }

    public int get(int key) {

        Tuple tuple = map.get(key);
        if (null == tuple)
            return -1;
        deleteTruple(tuple);
        tuple.times += 1;
        addTruple(tuple);
        return tuple.value;
    }

    public void set(int key, int value) {
        if (capacity == 0)
            return;

        Tuple tuple = map.get(key);
        if (tuple == null) {
            if (map.size() == capacity) {
                Integer firstKey = countMap.firstKey();
                Node node = countMap.get(firstKey);
                deleteTruple(node.head);
                map.remove(node.head.key);
            }

            tuple = new Tuple();
            tuple.value = value;
            tuple.key = key;
            tuple.times = 1;
            map.put(key, tuple);
            addTruple(tuple);
        } else {
            deleteTruple(tuple);
            tuple.value = value;
            tuple.times += 1;
            addTruple(tuple);
        }


    }


    private void addTruple(Tuple tuple) {
        int times = tuple.times;
        Node node = countMap.get(times);
        if (node == null) {
            countMap.put(tuple.times, new Node(tuple, tuple));
        } else {
            Tuple tail = node.tail;
            tail.next = tuple;
            tuple.front = tail;
            countMap.put(times, new Node(node.head, tuple));
        }

    }


    private void deleteTruple(Tuple tuple) {
        Tuple front = tuple.front;
        Tuple next = tuple.next;
        int times = tuple.times;
        Node node = countMap.get(times);
        Tuple head = node.head;
        Tuple tail = node.tail;

        if (front == null && next == null) {
            countMap.remove(times);
        } else if (front == null && next != null) {
            next.front = null;
            countMap.put(times, new Node(next, tail));
        } else if (front != null && next != null) {
            front.next = next;
            next.front = front;
            countMap.put(times, new Node(head, tail));

        } else {
            front.next = next;
            countMap.put(times, new Node(head, front));
        }
        tuple.front = null;
        tuple.next = null;

    }


    static class Tuple {
        int key;
        int value;
        int times;
        Tuple front;
        Tuple next;

        @Override
        public String toString() {
            return "Tuple{" +
                    "key=" + key +
                    ", value=" + value +
                    ", times=" + times +
                    '}';
        }
    }

    static class Node {

        @Override
        public String toString() {
            return "Node{" +
                    "head=" + head +
                    ", tail=" + tail +
                    '}';
        }

        public Node(Tuple head, Tuple tail) {
            this.head = head;
            this.tail = tail;
        }

        Tuple head;
        Tuple tail;

    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity */);

//        cache.set(1, 1);
//        cache.set(2, 2);
//        System.out.println(cache.get(1));       // returns 1
//        cache.set(3, 3);    // evicts key 2
//        System.out.println(cache.get(2));        // returns -1 (not found)
//        System.out.println(cache.get(3));        // returns 3.
//        cache.set(4, 4);    // evicts key 1.
//        System.out.println(cache.get(1));        // returns -1 (not found)
//        System.out.println(cache.get(3));        // returns 3
//        System.out.println(cache.get(4));        // returns 4

//        cache.set(0, 0);
//        System.out.println(cache.get(0));

        cache.set(2, 1);System.out.println(cache.countMap);

        cache.set(1, 1);System.out.println(cache.countMap);
        cache.set(2, 3);System.out.println(cache.countMap);
        cache.set(4, 1);System.out.println(cache.countMap);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

}
