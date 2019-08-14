package com.lhfeiyu.tech.structure.queue;


import java.util.*;

public class MyLinkList<E> implements List<E> {

    public static void main(String[] args) {
    }

    int modCount = 0;

    int size = 0;

    private Node<E> first = null;
    private Node<E> last  = null;

    /*MyLinkList(int size) {
        elementData = new Object[size];
    }

    MyLinkList() {
        //elementData = EMPTY_ELEMENTDATA;
        elementData = new Object[DEFAULT_CAPACITY];
    }*/


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        if (null != first) {
            Object[] ary = new Object[size];
            Node<E> current = first;
            int i = 0;
            while (null != current) {
                ary[i] = current.getData();
                current = current.getNext();
                i++;
            }
            return ary;
        }

        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /*private void checkGrow() {
        int len = elementData.length;
        if (len <= 10) {
            len = 10;
        }
        if (size >= len) {
            System.out.println("grow from " + len + " to " + (len * 2));
            Object[] elementDataNew = new Object[len * 2];
            for (int j = 0; j < len; j++) {
                elementDataNew[j] = elementData[j];
            }
            elementData = elementDataNew;
        }
    }*/

    @Override
    public boolean add(E e) {
        if (null == first) {
            first = new Node<E>();
            first.setData(e);
            last = first;
        } else if (first == last) {
            Node<E> node = new Node<>();
            node.setData(e);
            node.setLast(first);
            first.setNext(node);
            last = node;
        } else {
            Node<E> node = new Node<>();
            node.setData(e);
            node.setLast(last);
            last.setNext(node);
            last = node;
        }

        modCount++;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        remove(index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        first = null;
    }

    public Node<E> getNode(int index) {
        Node<E> current = first;
        int i = 0;
        while (null != current.getNext()) {
            if (index == i) {
                Node<E> node = current;
                return node;
            }
            i++;
            current = current.getNext();
        }
        return null;
    }

    @Override
    public E get(int index) {
        Node<E> node = getNode(index);
        if (null != node) {
            return node.getData();
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        //elementData[index] = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        //elementData[index] = element;
    }

    @Override
    public E remove(int index) {
        Node<E> node = getNode(index);
        if (null != node) {
            Node<E> last = node.getLast();
            Node<E> next = node.getNext();
            last.setNext(next);
            next.setLast(last);
            node.setNext(null);
            node.setNext(null);
            //node = null;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> current = first;
        int i = 0;
        while (null != current.getNext()) {
            if (current.equals(o)) {
                return i;
            }
            i++;
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}

