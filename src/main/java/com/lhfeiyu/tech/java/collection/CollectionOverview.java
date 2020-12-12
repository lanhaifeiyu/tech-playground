package com.lhfeiyu.tech.java.collection;

import java.util.*;

<<<<<<< HEAD
/**
 * TODO
 *
 * @author airson
 */
public class CollectionOverview {

    public static void main(String[] args) {
        List<String> userList = new ArrayList<>();
        Set<String> userSet = new HashSet<>();
        Map<String,String> userMap = new HashMap<>();
    }

=======
public class CollectionOverview {

    public static void main(String[] args) {
        demo();
    }

    public static void demo() {

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Map<String, String> map = new HashMap<>();

        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        set.add("aaa");
        set.add("bbb");
        set.add("aaa");
        map.put("aaa", "1");
        map.put("aaa", "1");
        map.put("bbb", "1");


    }
>>>>>>> origin/master

}
