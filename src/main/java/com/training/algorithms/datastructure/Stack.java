package com.training.algorithms.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        private T item;
        private Node<T> next;
    }

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void push(T item) {
        Node<T> oldfirst = top;
        top = new Node();
        top.item = item;
        top.next = oldfirst;
        size++;
    }

    public T pop() {
        if (isEmpty()){
            throw new NoSuchElementException("Stack underflow");
        }
        T item = top.item;
        top = top.next;
        size--;
        return item;
    }


    public T peek() {
        if (isEmpty()){
            throw new NoSuchElementException("Stack underflow");
        }
        return top.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this) {
            s.append(item.toString());
            s.append(' ');
        }
        return s.toString();
    }


    public Iterator<T> iterator() {
        return new ListIterator(top);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }


    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.peek();
        System.out.println(stack);
        System.out.println(stack.size());
    }
}