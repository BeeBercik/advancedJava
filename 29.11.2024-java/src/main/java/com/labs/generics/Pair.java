package com.labs.generics;

import java.util.List;

public class Pair<T extends List<String>, W> {
    private T x;
    private W y;

    public Pair(T x, W y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public W getY() {
        return y;
    }

    public void setY(W y) {
        this.y = y;
    }

    public void displayElements() {
        this.x.forEach(System.out::println);
    }
}
