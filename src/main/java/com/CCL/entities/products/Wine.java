package com.CCL.entities.products;

import com.CCL.entities.products.Product;

import javax.persistence.*;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
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

    public Wine(int vintage, String varietal, String color, String importer) {
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
