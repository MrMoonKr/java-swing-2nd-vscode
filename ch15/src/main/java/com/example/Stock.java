// Stock.java
// A simple aggregate class for storing stock market information on a single
// stock (symbol, price, etc.).
//
package com.example;

import java.util.*;

public class Stock {
    public String symbol;
    public double price;
    public double delta;
    public Date lastUpdate;

    public Stock( String s, double p ) {
        symbol = s;
        price = p;
        lastUpdate = new Date();
    }

    public void update( double d ) {
        delta = d;
        price += delta;
    }

    public void print() {
        System.out.println( symbol + ": " + price + " (" + delta + ") last updated " + lastUpdate );
    }
}
