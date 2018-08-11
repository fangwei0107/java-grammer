package com.chinawyny.algorithm;

import java.util.ArrayList;
import java.util.List;

public interface Pair<K, V> {

    K  getKey();

    V getValue();

}

class OrderedPair<K, V> implements Pair<K, V> {

    List<K> keyList = new ArrayList<>();

    private K key;

    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        keyList.add(key);
        keyList.add(key);
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        OrderedPair<String, String> orderedPair = new OrderedPair<>("1", "2");
        System.out.println(orderedPair.keyList);

        Pair<Integer, String> p1 = new OrderedPair<>(1, "apple");
        Pair<Integer, String> p2 = new OrderedPair<>(2, "pear");
        System.out.println(Util.<Integer, String>compare(p1, p2));
    }
}
