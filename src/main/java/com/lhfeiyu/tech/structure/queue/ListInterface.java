package com.lhfeiyu.tech.structure.queue;

public interface ListInterface<E> {

    E add(E e);

    E remove(E e);

    E get(int index);

    E find(E e);

    E contains(E e);

    void clear();

}

