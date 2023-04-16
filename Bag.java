package com.lpa.simplegraph;

import java.util.Iterator;

public class Bag<T> implements Iterable<T>{

    private class Node{
        private T val;
        private Node next;
        private Node(Node next, T val){
            this.next = next;
            this.val = val;
        }
    }

    private Node head;
    private int size;

    public Bag(){
    }

    public void add(T val){
        head = new Node(head, val);
        size+=1;
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new myIterator();
    }

    private class myIterator implements Iterator<T>{

        Node current = head;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T v = current.val;
            current=current.next;
            return v;
        }
    }

}
