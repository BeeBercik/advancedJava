package com.labs.javaVersions.java9;

// klasa impl ten interf nie musi dostarczac ciala metody default metoda3(), moze byc domyslnych ile chcemy

// prywatne metody sluza do rozbicia kodu z metody default (tez moga miec cialo ale nie da sie ich przeslonic)

// raczej stosujemy interfejs z tradycyjnymi abstr. metodami bez default - gdy potrzeba metody z implementacja (cialem) to robimy klase abstrakcyjna

public interface Interfejs {
    void metoda1();
    void metoda2();

    default void metodaDom1() {
       cos1();
       cos2();
    }

    default void metodaDom2() {
        System.out.println("dom2");
    }

    private void cos1() {
        System.out.println("cos1");
    }

    private void cos2() {
        System.out.println("cos2");
    }
}
