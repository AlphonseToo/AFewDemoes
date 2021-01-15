package com.thinking.demo.chapter17;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/11/25 11:52
 * @since 1.0
 **/
class MapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;
    public MapEntry<K, V> next = null;
    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V setValue(V value) {
        this.value = value;
        return value;
    }

    @Override
    public String toString() {
        return "MapEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    private MapEntry<K, V>[] buckets;

    public SimpleHashMap() {
        this.buckets = new MapEntry[SIZE];
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        MapEntry<K, V> tail = buckets[index];
        if(tail == null) {
            buckets[index] = new MapEntry<>(key, value);
            return null;
        }
        while(tail != null) {
            if(tail.getKey().equals(key)) {
                oldValue = tail.getValue();
                tail.setValue(value);
                return oldValue;
            }
            tail = tail.next;
        }
        tail = new MapEntry<>(key, value);
        return null;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        MapEntry<K, V> tail = buckets[index];
        while(tail != null){
            if(tail.getKey().equals(key)) {
                return tail.getValue();
            }
            tail = tail.next;
        }
        return null;
    }
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for(MapEntry bucket : buckets) {
            if(bucket == null) continue;
            MapEntry<K, V> tail = bucket;
            while(tail != null) {
                set.add(tail);
                tail = tail.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        m.put("1", "11");
        m.put("2", "22");
        m.put("3", "33");
        m.put("4", "44");
        System.out.println(m);
    }
}

public class E25 {
}
