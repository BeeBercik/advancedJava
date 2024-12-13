package com.homework;

import java.util.List;

public class Zad1 {
    public static void main(String[] args) {
        List<Integer> list = List.of(45, 39, 17, 25, 10, 4);

        list.stream()
                .map(String::valueOf)
                .filter(i -> !i.endsWith("9"))
                .filter(i -> !i.endsWith("7"))
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);
    }
}