package com.lhfeiyu.tech.structure.queue;


import java.util.*;

public class MyArrayList<E> implements List<E> {

    public static void main(String[] args) {
    }

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    Object[] elementData;

    int modCount = 0;

    int size = 0;

    MyArrayList(int size) {
        elementData = new Object[size];
    }

    MyArrayList() {
        //elementData = EMPTY_ELEMENTDATA;
        elementData = new Object[DEFAULT_CAPACITY];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return elementData.length == 0;
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
        return elementData;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    private void checkGrow() {
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
    }

    @Override
    public boolean add(E e) {
        checkGrow();
        elementData[size] = e;
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
        elementData = EMPTY_ELEMENTDATA;
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        elementData[index] = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        elementData[index] = element;
    }

    @Override
    public E remove(int index) {
        Object o = elementData[index];
        elementData[index] = null;
        return (E) o;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(o)) {
                return i;
            }
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

