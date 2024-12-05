package com.labs.javaVersions.java9;

// metody fabrykujace zwracaja kolekcje niemutowalne (niemodyfikowalne)

// hashmapa posiada tablice hashujaca w ktorej sa przechowywane po zahashowanymi key ich wartosci
// gdy siegamy pod klucz np int 3 to jest on hashowany i odnajdowany w tablicy wrac z przypisana wartoscia

// mapa sklada sie z par (obietkow entries) Map.entry(klucz, wartosc),

import java.util.HashMap;
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
//        lub zamiast wartosci i kluczy to boiekty entry
        Map<Integer, String> mapEntries = Map.ofEntries(Map.entry(1, "Robert"), Map.entry(2, "Kamil"));
        System.out.println(mapEntries);

//        z mapy nie mozna zrobic strumienia ALE mozna na jej parach
        HashMap<Integer, String> myMap = new HashMap<>();
        Map.Entry<Integer, String> entry = Map.entry(1, "Robert");
        myMap.put(entry.getKey(), entry.getValue());
        myMap.put(2, "Wera");

//        myMap.stream NIE MA mozlwisoci strumienia na mapie

        System.out.println(myMap.entrySet());
            // tak sie robi strumien na mapie
        myMap.entrySet().stream()
                .filter(e -> e.getKey() == 1)
                .forEach(System.out::println);

        new Client().metodaDom1();
        new Client().metodaDom2();
    }
}

class Client implements Interfejs {
    @Override
    public void metoda1() {
    }

    @Override
    public void metoda2() {}


}
