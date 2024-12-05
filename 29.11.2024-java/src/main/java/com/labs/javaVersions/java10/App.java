package com.labs.javaVersions.java10;

import java.util.List;

// kopiowanie kolekcji
// np sortujemy glowna liste i chcemy porownac czy jest pososrtowana to tworzymy na jej bazie pomocnicza

// VAR nie dziala jak w js ze mozna przypisywac rozne typy, obojente jakie, tylko jak sie przypisze juz jakis typ to ta zmienna var przyjmuje ten typ na stale

// gdy nie interesuje nas co np metoda zwraca to dajemy var i zawsze linijka kodu dziala (nie ma sytuacji ze robimy zmienna String a metoda zwroci int i jest blad)

public class App {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> list2 = List.copyOf(list);
        System.out.println(list2);

//       VAR
        var name = "Robert";
        System.out.println(name);
//        name = 3; blad - name ma typ String
    }
}
