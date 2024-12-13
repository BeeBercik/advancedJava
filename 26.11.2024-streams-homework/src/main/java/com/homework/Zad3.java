package com.homework;

import java.util.List;

public class Zad3 {
    public static void main(String[] args) {
        List<String> list = List.of("aa", "cy", "b", "yycd", "c");

        list.stream()
                .map(i -> i + "y")
                .filter(i -> !i.contains("yy"))
                .forEach(System.out::println);
    }
}
