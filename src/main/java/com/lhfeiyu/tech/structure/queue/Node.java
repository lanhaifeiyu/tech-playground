package com.lhfeiyu.tech.structure.queue;


public class Node<E> {

    private Node next;
    private Node last;
    private E    data;

    @Override
    public String toString() {
        return data.toString();
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

}

