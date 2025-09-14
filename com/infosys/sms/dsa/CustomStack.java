package com.infosys.sms.dsa;

import com.infosys.sms.exception.EmptyDataStructureException;

public class CustomStack<T> {
    private Object[] data;
    private int top;

    public CustomStack(int capacity) {
        data = new Object[capacity];
        top = -1;
    }

    public void push(T val) {
        if (top == data.length - 1) {
            System.arraycopy(data, 1, data, 0, top);
            top--;
        }
        data[++top] = val;
    }

    public T pop() throws EmptyDataStructureException {
        if (isEmpty()) throw new EmptyDataStructureException("Stack is empty");
        return (T) data[top--];
    }

    public T peek() throws EmptyDataStructureException {
        if (isEmpty()) throw new EmptyDataStructureException("Stack is empty");
        return (T) data[top];
    }

    public boolean isEmpty() { return top == -1; }

    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.println(data[i]);
        }
    }
}

