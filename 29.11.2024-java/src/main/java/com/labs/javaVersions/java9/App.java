package com.labs.javaVersions.java9;

// metody fabrykujace zwracaja kolekcje niemutowalne (niemodyfikowalne)

import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        List<String> list = List.of("robert", "kamil", "olek");
        System.out.println(list);
//        list.add("wera"); blad - ine da sie dodac
        Set<Integer> set = Set.of(1, 2, 3);
        System.out.println(set);
        Map<String, Integer> map = Map.of("robert", 22, "kamil", 21);
        System.out.println(map);
    }
}
