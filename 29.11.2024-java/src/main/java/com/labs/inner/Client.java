package com.labs.inner;

public class Client {
    private int id;
    private String name;
    private String surname;
    private Address address = new Address(); // domylsnie tu tworzymy aby nie na zentarz
    private Wallet wallet = new Client.Wallet(); // jesli w srodku robimy to niewazne czy static czy nie

    public Client(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public class Address {
        private String street;
        private String city;

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    public static class Wallet {
        private int cash;
        private int cardBalance;

        @Override
        public String toString() {
            return "Wallet{" +
                    "cash=" + cash +
                    ", cardBalance=" + cardBalance +
                    '}';
        }
    }
}