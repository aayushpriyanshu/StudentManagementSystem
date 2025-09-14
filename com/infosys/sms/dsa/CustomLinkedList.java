package com.infosys.sms.dsa;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class CustomLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T d) { data = d; }
    }

    private Node<T> head, tail;
    private int size;

    public void add(T val) {
        Node<T> n = new Node<>(val);
        if (head == null) head = tail = n;
        else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public boolean remove(Predicate<T> predicate) {
        Node<T> prev = null, curr = head;
        while (curr != null) {
            if (predicate.test(curr.data)) {
                if (prev == null) head = curr.next;
                else prev.next = curr.next;
                if (curr == tail) tail = prev;
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public T find(Predicate<T> predicate) {
        Node<T> curr = head;
        while (curr != null) {
            if (predicate.test(curr.data)) return curr.data;
            curr = curr.next;
        }
        return null;
    }

    public void forEach(Consumer<T> action) {
        Node<T> curr = head;
        while (curr != null) {
            action.accept(curr.data);
            curr = curr.next;
        }
    }

    public int size() { return size; }
}
