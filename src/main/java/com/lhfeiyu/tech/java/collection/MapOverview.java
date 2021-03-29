package com.lhfeiyu.tech.java.collection;

import java.util.*;

/**
 * TODO
 *
 * @author airson
 */
public class MapOverview {

    public static void main(String[] args) {
        demo();
    }

    public static void demo() {

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        set.add("aaa");
        set.add("bbb");
        set.add("aaa");
        map.put("aaa1", 1);
        map.put("aaa2", 2);
        map.put("aaa3", 3);
        map.put("aaa4", 4);
        map.put("aaa5", 5);
        map.put("aaa6", 6);
        map.put("aaa7", 7);
        map.put("aaa8", 8);
        map.put("aaa9", 9);
        map.put("aaa10", 10);
        map.put("aaa11", 11);
        map.put("aaa12", 12);
        map.put("aaa13", 13);
        map.put("aaa14", 14);
        map.put("aaa15", 15);
        map.put("aaa16", 16);// map default 16
        map.put("aaa17", 17);
        map.put("aaa17", 17);
        map.put("aaaaaaaaaaaaaa17", 17);
        map.put("aaaaaaaaaaaaaa18", 18);
        map.put("aaaaaaaaaaaaaa19", 19);
        Integer val = map.get("aaa16");
        map.remove("aaa10");

    }

}
