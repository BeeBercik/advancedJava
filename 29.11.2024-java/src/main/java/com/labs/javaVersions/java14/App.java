package com.labs.javaVersions.java14;

// Pattern matching

// REKORDU - niemodyfikowalne obiekty (zamiast klas z final polami i getterami)

import com.labs.inner.Client;

public class App {
    public static void main(String[] args) {
        Object o = new Client(1, "Robert", "Kania");
        if(o instanceof Client) {
            Client c = (Client) o;
            System.out.println(c.getName());
        }
        // Skrocony zapis: po sprawdzeniu samo przypisuje do zmiennej rzutjac na typ
        Object x = new Client(2, "Weronika", "Kozik");
        if(x instanceof Client y) {
            System.out.println(y.getName());
        }

//        REKORDY
        CarRecord carRecord = new CarRecord("Audi", "RS6", 2024);
        System.out.println(carRecord);
        System.out.println(carRecord.model()); // gettery bez get - po  nazwach pol
        carRecord.printBeautyBrasnd();
    }
}
