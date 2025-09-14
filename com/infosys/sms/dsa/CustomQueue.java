package com.infosys.sms.dsa;

import com.infosys.sms.exception.EmptyDataStructureException;

public class CustomQueue<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T d) { data = d; }
    }

    private Node<T> front, rear;

    public void enqueue(T val) {
        Node<T> n = new Node<>(val);
        if (rear == null) front = rear = n;
        else {
            rear.next = n;
            rear = n;
        }
    }

    public T dequeue() throws EmptyDataStructureException {
        if (front == null) throw new EmptyDataStructureException("Queue is empty");
        T val = front.data;
        front = front.next;
        if (front == null) rear = null;
        return val;
    }

    public T peek() throws EmptyDataStructureException {
        if (front == null) throw new EmptyDataStructureException("Queue is empty");
        return front.data;
    }

    public void printQueue() {
        Node<T> curr = front;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}

