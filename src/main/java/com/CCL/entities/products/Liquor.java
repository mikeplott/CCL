package com.CCL.entities.products;

import javax.persistence.*;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity

    @NamedQuery(name = "liquorUpdater",
       query = "update ProductMetaData w set w.name = ?1, w.description = ?2,  w.itemCode = ?3, w.origin = ?4," +
                "w.volume = ?5, w.frontPrice = ?6, w.tenCasePrice = ?7, w.twentyFiveCasePrice = ?8, w.cost = ?9," +
                "w.bottleWeight = ?10, w.caseWeight = ?11, w.quantity = ?12, w.isExclusive = ?13, w.isDualState = ?14," +
                "w.caseSize = ?15, w.liquorType = ?16, w.distillery = ?17, w.liquorID = ?18 where w.id = ?19")

@Table(name = "liquours")
public class Liquor extends Product {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String liquorType;

    @Column(nullable = false)
    private String distillery;

    public Liquor() {
    }

    public Liquor(String name, String description, String itemCode, String origin, String volume,
                  double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost,
                  double bottleWeight, double caseWeight, int quantity, boolean isExclusive,
                  boolean isDualState, Product.caseSize caseSize, String liquorType, String distillery) {
        super(name, description, itemCode, origin, volume, frontPrice, tenCasePrice, twentyFiveCasePrice, cost,
                bottleWeight, caseWeight, quantity, isExclusive, isDualState, caseSize);
        this.liquorType = liquorType;
        this.distillery = distillery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLiquorType() {
        return liquorType;
    }

    public void setLiquorType(String liquorType) {
        this.liquorType = liquorType;
    }

    public String getDistillery() {
        return distillery;
    }

    public void setDistillery(String distillery) {
        this.distillery = distillery;
    }
}