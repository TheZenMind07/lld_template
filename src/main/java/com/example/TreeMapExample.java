package com.example;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExample {

    static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(40, "Fruit");
        tm.put(20, "Tomoato");
        tm.put(90, "Neel");
        tm.put(10, "toyot");

        // Iterate
        for(Map.Entry<Integer, String> entry : tm.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // submap
        SortedMap<Integer, String> subTree = tm.subMap(20, 50);
        for(Map.Entry<Integer, String> entry : subTree.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // Ceiling
        System.out.println(tm.ceilingEntry(10));
        System.out.println(tm.lowerEntry(10));
        System.out.println(tm.floorEntry(20));
        System.out.println(tm.higherEntry(20));



    }
}
