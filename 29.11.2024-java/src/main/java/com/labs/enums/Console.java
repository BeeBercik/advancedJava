package com.labs.enums;

// Enuma uzywamy, gdy chcemy aby np w zmiennej przechocwyac konkretna wartosc tak samo np enum Plec z rodzajami (nie ma innych, ograniczamy wybir).

// W enum konstruktory domyslnie sa prywatne, bo obeikty klasy enuma tworzymy w niej, na poczatku wymieniajace a nie na zewnatrz (bo taki zamysl enuma - nie tworzyc na zwenatrz z dowolnymi warotsciami jak wzykla klasa!). Tak naprawde tworzymy wtedy obiekty wlasnie tej klasy o konkretnych nazwach (konwencja wielkie litery).

// Roznice miedzy enum a zwykla klasa: konstruktor zawsze prywatny, na poczatku tworzymy obiekty tej klasy enum(wraz z ich wlasciowscami itd wywolujac konstr klasy enum)
// Gdy stworzymy enum z obiektem PS4 to on zawierza wszystko co klasa Console (bo to obiekt tej klasy) czyli gettery itd konstr

public enum Console {
    PS4("Sony", "AMD", "Intel", "4"),
    PS5("Sony", "AMD", "Intel", "5"),
    XBOXONE("Sony", "AMD", "Intel", "ONE");

    private String brand;
    private String cpu;
    private String gpu;
    private String version;

    Console(String brand, String cpu, String gpu, String version) {
        this.brand = brand;
        this.cpu = cpu;
        this.gpu = gpu;
        this.version = version;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Console{" +
                "brand='" + brand + '\'' +
                ", cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
