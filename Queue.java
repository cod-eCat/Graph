package com.lpa.simplegraph;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T>{

    private class Node{
        private T val;
        private Node next;
        private Node(T val){
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public Queue(){

    }

    public void enqueue(T val){
        Node node = new Node(val);
        if (isEmpty()){
            head = node;
            tail = node;
            size+=1;
            return;
        }
        tail.next = node;
        tail = node;
        size+=1;
    }

    public T dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        T val = head.val;
        head = head.next;
        size-=1;
        return val;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
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
            T val = current.val;
            current = current.next;
            return val;
        }
    }

}
