package com.labs.javaVersions.java11;

// Metody dla String
// Stringi sa niemutowalne tzn nie mozna ich zmienic, tylko kazda metoda na nich zwraca nowego Stringa (np trzeba przypisac do nowej zmiennej)

public class App {
    public static void main(String[] args) {
        String s = "123";
        String s2 = s.repeat(3);
        System.out.println(s2);

        String s3 = " ABC ";
        System.out.println(s3.trim()); // usuwa na koncu i na poczatku SPACJE
        System.out.println(s3.stripLeading());
        System.out.println(s3.stripTrailing());
        System.out.println(s3.strip()); // wszystkie biale znaki tzn tabulatory itd

        s3.isEmpty(); // czy jest pusty ""
        s3.isBlank(); // czy zawiera tylko znaki biale " ", "\n", "\t" itd LUB jest pusty " "

//        WAZNE - gdy np dostajemy info w pliku
        String cos = "Siemka\nTo ja jestem robert\nNarazie!";
        // .lines() zwraca strumien Stringow do dalszego przetwarzania
        cos.lines().forEach(System.out::println);
    }
}
