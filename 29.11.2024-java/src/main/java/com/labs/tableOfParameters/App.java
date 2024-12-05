package com.labs.tableOfParameters;

// podobnie jak w javascript ... zbeira do tablicy!
// (typ_parametrow... zmienna_tablica)

public class App {
    public static void main(String[] args) {
        App.showElements(1, 3, 2);

        App.showElementsUniversal("a", 2, 'a', 2.5);
    }

    public static void showElements(int... x) {
        System.out.println(x[0]);
        System.out.println(x[1]);
//        x to tablica!
    }

    public static <T> void showElementsUniversal(T... x) {
        System.out.println(x[0]);
        System.out.println(x[1]);
        System.out.println(x[2]);
        System.out.println(x[3]);
    }
}
