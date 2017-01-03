package com.CCL.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "beers")
public class Beer extends Product {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private Timestamp lotDate;

    @Column(nullable = false)
    private Timestamp expirationDate;

    @Column(nullable = false)
    private String beerType;

    @Column(nullable = false)
    private String brewery;

    @Column(nullable = false)
    private boolean isDomestic;

    @Column(nullable = false)
    private boolean isSeasonal;

    public Beer() {
    }

    public Beer(Timestamp lotDate, Timestamp expirationDate, String beerType, String brewery, boolean isDomestic, boolean isSeasonal) {
        this.lotDate = lotDate;
        this.expirationDate = expirationDate;
        this.beerType = beerType;
        this.brewery = brewery;
        this.isDomestic = isDomestic;
        this.isSeasonal = isSeasonal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getLotDate() {
        return lotDate;
    }

    public void setLotDate(Timestamp lotDate) {
        this.lotDate = lotDate;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBeerType() {
        return beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public boolean isDomestic() {
        return isDomestic;
    }

    public void setDomestic(boolean domestic) {
        isDomestic = domestic;
    }

    public boolean isSeasonal() {
        return isSeasonal;
    }

    public void setSeasonal(boolean seasonal) {
        isSeasonal = seasonal;
    }
}
