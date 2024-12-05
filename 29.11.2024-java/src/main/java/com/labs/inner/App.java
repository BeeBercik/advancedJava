package com.labs.inner;

public class App {
    public static void main(String[] args) {
        Client.Address address = new Client(1, "Karol", "Bobrekk").new Address();
        System.out.println(address);

        Client.Wallet wallet = new Client.Wallet();
        System.out.println(wallet);

        // zamiast na zewnatrz tworzyc obiekt klasy wewnetrznej i na nim np uzyc setterow - tworzymy wewnatrz klasy ZEWNETRZNEJ domyslnie pusty obiekt jej i na nim (wlasciwoscie zwen. klasy) uzywamy getterow i setterow
        Client client = new Client(1, "Karol", "Bobrekk");
        client.getAddress().setCity("Wadowice");
        System.out.println(client.getAddress());

        System.out.println(new Client(1, "Karol", "Bobrekk").getWallet());

        // gdy do wlasciwosci klasy zewnetrznej przypiszemy bazawo obiekty klas wewntrznych, to nie ma roznicy czy klasa wewn. jest static czy nie - przypisujemy ja do wlasciwosci nie static, do ktorej mamy np gettera. Wlasciwosc jest zwykla - to klasa (juz przypisana do niej) jest static. Pozniej pracujemy na zwyklej wlasciwosci
    }
}
