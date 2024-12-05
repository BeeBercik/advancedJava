package com.labs.javaVersions.java12;

// krotki switch zwraca wartosc dopasowana do warunku - podobnie jak trojargumantowy if

public class App {
    public static void main(String[] args) {
        int x = 2;
        String mess = "";

        switch(x) {
            case 1:
                mess = "It is 1!";
                break;
            case 2:
                mess = "It is 2!";
                break;
            case 3:
                mess = "It is 3!";
                break;
            default:
                mess = "The value is unknown!";
                break;
        }
        System.out.println(mess);

        String result = switch(x) {
            case 1 -> "It is 1!";
            case 2 -> "It is 2!";
            case 3 -> "It is 3!";
            default -> "It is unknown!";
        };
        System.out.println(result);
    }
}
