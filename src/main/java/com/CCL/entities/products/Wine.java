package com.CCL.entities.products;

import org.hibernate.annotations.NamedQuery;
import javax.persistence.*;

/**
 * Created by michaelplott on 1/3/17.
 */

@Entity

@NamedQuery( name = "wineUpdater",
        query = "update ProductMetaData w set w.name = ?1, w.description = ?2,  w.itemCode = ?3, w.origin = ?4, " +
        "w.volume = ?5, w.frontPrice = ?6, w.tenCasePrice = ?7, w.twentyFiveCasePrice = ?8, w.cost = ?9, " +
        "w.bottleWeight = ?10, w.caseWeight = ?11, w.quantity = ?12, w.isExclusive = ?13, w.isDualState = ?14, " +
        "w.caseSize = ?15, w.vintage = ?16, w.varietal = ?17, w.color = ?18, w.importer = ?19, w.wineID = ?20 " +
        "where w.id = ?21")

@Table(name = "wines")
public class Wine extends Product {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private int vintage;

    @Column(nullable = false)
    private String varietal;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String importer;


    public Wine() {
    }

    public Wine(String name, String description, String itemCode, String origin, String volume, double frontPrice,
                double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight, double caseWeight,
                int quantity, boolean isExclusive, boolean isDualState, int vintage, String varietal, String color,
                String importer, Product.caseSize caseSize) {
        super(name, description, itemCode, origin, volume, frontPrice, tenCasePrice, twentyFiveCasePrice, cost,
                bottleWeight, caseWeight, quantity, isExclusive, isDualState, caseSize);
        this.vintage = vintage;
        this.varietal = varietal;
        this.color = color;
        this.importer = importer;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVintage() {
        return vintage;
    }

    public void setVintage(int vintage) {
        this.vintage = vintage;
    }

    public String getVarietal() {
        return varietal;
    }

    public void setVarietal(String varietal) {
        this.varietal = varietal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImporter() {
        return importer;
    }

    public void setImporter(String importer) {
        this.importer = importer;
    }
}