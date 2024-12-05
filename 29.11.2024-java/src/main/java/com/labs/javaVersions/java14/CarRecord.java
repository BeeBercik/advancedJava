package com.labs.javaVersions.java14;

// record posiada wbudo0wane gettery (po nazwach pol np brand() nie getbrand(), toString() itd
// jak w zwyklej klasie moga byc inne metody

public record CarRecord(String brand, String model, int year) {

    public void printBeautyBrasnd() {
        System.out.println("*--" + this.brand + "--*"); // normalnie po this do wlasciwosci
    }
}
