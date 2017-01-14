package com.CCL.entities.products;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity

@NamedQuery(name = "beerUpdater",
        query = "update Beer w set w.name = ?1, w.description = ?2,  w.itemCode = ?3, w.origin = ?4," +
        "w.volume = ?5, w.frontPrice = ?6, w.tenCasePrice = ?7, w.twentyFiveCasePrice = ?8, w.cost = ?9," +
        "w.bottleWeight = ?10, w.caseWeight = ?11, w.quantity = ?12, w.isExclusive = ?13, w.isDualState = ?14," +
        "w.caseSize = ?15, w.lotDate = ?16, w.expirationDate = ?17, w.beerType = ?18, w.brewery = ?19," +
        "w.isDomestic = ?20, w.isSeasonal = ?21  where w.id = ?22")

@Table(name = "beers")
public class Beer extends Product {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private Date lotDate;

    @Column(nullable = false)
    private Date expirationDate;

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

    public Beer(String name, String description, String itemCode, String origin, String volume, double frontPrice,
                double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight, double caseWeight,
                int quantity, boolean isExclusive, boolean isDualState, Date lotDate, Date expirationDate,
                String beerType, String brewery, boolean isDomestic, boolean isSeasonal, Product.caseSize caseSize) {
        super(name, description, itemCode, origin, volume, frontPrice, tenCasePrice, twentyFiveCasePrice, cost,
                bottleWeight, caseWeight, quantity, isExclusive, isDualState, caseSize);
        this.lotDate = lotDate;
        this.expirationDate = expirationDate;
        this.beerType = beerType;
        this.brewery = brewery;
        this.isDomestic = isDomestic;
        this.isSeasonal = isSeasonal;
        Beer.caseSize caseSize1 = caseSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLotDate() {
        return lotDate;
    }

    public void setLotDate(Date lotDate) {
        this.lotDate = lotDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
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