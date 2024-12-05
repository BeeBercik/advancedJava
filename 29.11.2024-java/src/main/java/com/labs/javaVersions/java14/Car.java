package com.labs.javaVersions.java14;

//Niemutowalna klasa - wszystkie pola prywatne i tylko gettery. Tworzymy obiekt przez konstukrot i nic sie w niej nie da zmienic.

// Zamiast tak dlugiego zapisu powstaly REKORDY

public class Car {
    private final String model;
    private final String brand;
    private final int year;

    public Car(String model, String brand, int age) {
        this.model = model;
        this.brand = brand;
        this.year = age;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }
}
