package com.labs.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
//  Klasa generyczna
        Pair<List<String>, Integer> pair = new Pair<>(List.of("Robert", "Weronika"), 10);
        System.out.println(pair.getX());
        System.out.println(pair.getY());

        pair.displayElements();

//  Lista statyczna generyczna
        List<Integer> intlist = App.getListT(69);
        System.out.println(intlist);
        // wild card - typ zwracany zalezy od tego co podamy (implementacja metody generycznej)
        List<?> unknownTypeList = App.getListT("aaa");
        System.out.println(unknownTypeList);
        List<?> unknownTypeList2 = App.getListT(500);
        System.out.println(unknownTypeList2);
        // mozna zrobic taki myk
        List<? extends Number> listOfTypeNumber = App.getListT(69.0); // el. listy maja byc podtypami number
        System.out.println(listOfTypeNumber);

        System.out.println(App.getListT(2));

//  Mapa zwykla generyczna
        Map<Integer, String> myMap = new App().getMap(5, "Kamil");
        System.out.println(myMap);

        Map<?, ?> randomMap = new App().getMap("Ola", "Majowska");
        System.out.println(randomMap);
    }

    public static <T> List<T> getListT(T t) {
//        return List.of(t);
        List<T> list = new ArrayList<>();
        list.add(t);
        return list;
    }

    public <T, W> Map<T, W> getMap(T x, W y) {
//        return Map.of(x, y);
        Map<T, W> map = new HashMap<>();
        map.put(x, y);
        return map;
    }
}
