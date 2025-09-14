package com.infosys.sms.dsa;

import java.util.LinkedList;

public class CustomHashTable<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K k, V v) { key = k; value = v; }
    }

    private LinkedList<Entry<K, V>>[] buckets;
    private int capacity;

    public CustomHashTable(int capacity) {
        this.capacity = capacity;
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) buckets[i] = new LinkedList<>();
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int idx = hash(key);
        for (Entry<K, V> e : buckets[idx]) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }
        buckets[idx].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int idx = hash(key);
        for (Entry<K, V> e : buckets[idx]) {
            if (e.key.equals(key)) return e.value;
        }
        return null;
    }

    public void remove(K key) {
        int idx = hash(key);
        buckets[idx].removeIf(e -> e.key.equals(key));
    }
}
