package com.lhfeiyu.tech.structure.queue;

import java.util.Arrays;

public class MyListDemo {

    public static void main(String[] args) {

        //MyArrayList<Integer> list = new MyArrayList<>();
        MyLinkList<Integer> list = new MyLinkList<>();
        for (int i = 1; i < 100; i++) {
            list.add(i);
        }

        System.out.println(Arrays.toString(list.toArray()));

        list.remove(5);
        list.set(2, 20);

        System.out.println(list.get(5));

        System.out.println(Arrays.toString(list.toArray()));

        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println(Arrays.toString(stack.toArray()));
        Integer top = stack.peek();
        System.out.println(top);

    }


}

