package com.CCL.entities;

import javax.persistence.*;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
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

    public Liquor(String liquorType, String distillery) {
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
