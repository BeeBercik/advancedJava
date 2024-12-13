package com.homework;

import java.util.List;

public class Zad2 {
    public static void main(String[] args) {
        List<Integer> list = List.of(3, 10, 9, 4);

        list.stream()
                .map(i -> (i * i) + 9)
                .map(String::valueOf)
                .filter(i -> !i.contains("9"))
                .forEach(System.out::println);

    }
}
