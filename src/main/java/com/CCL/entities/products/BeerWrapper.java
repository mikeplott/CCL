package com.CCL.entities.products;

import java.util.ArrayList;

/**
 * Created by Mike on 1/10/2017.
 */
public class BeerWrapper {

    ArrayList<Beer> theBeers;

    public BeerWrapper() {
    }

    public BeerWrapper(ArrayList<Beer> theBeers) {
        this.theBeers = theBeers;
    }

    public ArrayList<Beer> getTheBeers() {
        return theBeers;
    }

    public void setTheBeers(ArrayList<Beer> theBeers) {
        this.theBeers = theBeers;
    }
}
