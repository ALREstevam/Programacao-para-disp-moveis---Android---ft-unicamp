package br.unicamp.ft.a166348.aplicacaoartista.utils;

/**
 * Created by andre on 20/04/2018.
 */

public class Touple<T, S> {
    private T first;
    private T second;

    public Touple() {

    }

    public Touple(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
