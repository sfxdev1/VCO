package com.keith.vco;

/**
 * Created by Development on 11/25/2016.
 */
public class Capsule<D> {
    public D data;

    private Capsule(D data) {
        this.data = data;
    }

    public static <I> Capsule<I> encapsulate(I data) {
        return new Capsule<I>(data);
    }
}
