package com.CCL.entities.employees;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "salesreps")
public class SalesRep extends Employee {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private BigDecimal totalDollarSales;

    @Column(nullable = false)
    private BigDecimal totalDollarReturns;

    @Column(nullable = false)
    private double beerSales;

    @Column(nullable = false)
    private double wineSales;

    @Column(nullable = false)
    private double liquorSales;

    @Column(nullable = false)
    private String territory;

    @Column(nullable = false)
    private boolean isPodLeader;

    @Column(nullable = false)
    private boolean isRegionalManager;

    @Column(nullable = false)
    private boolean isSalesManager;

    public SalesRep() {
    }

    public SalesRep(BigDecimal totalDollarSales, BigDecimal totalDollarReturns, double beerSales, double wineSales,
                    double liquorSales, String territory, boolean isPodLeader, boolean isRegionalManager, boolean isSalesManager) {
        this.totalDollarSales = totalDollarSales;
        this.totalDollarReturns = totalDollarReturns;
        this.beerSales = beerSales;
        this.wineSales = wineSales;
        this.liquorSales = liquorSales;
        this.territory = territory;
        this.isPodLeader = isPodLeader;
        this.isRegionalManager = isRegionalManager;
        this.isSalesManager = isSalesManager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getTotalDollarSales() {
        return totalDollarSales;
    }

    public void setTotalDollarSales(BigDecimal totalDollarSales) {
        this.totalDollarSales = totalDollarSales;
    }

    public BigDecimal getTotalDollarReturns() {
        return totalDollarReturns;
    }

    public void setTotalDollarReturns(BigDecimal totalDollarReturns) {
        this.totalDollarReturns = totalDollarReturns;
    }

    public double getBeerSales() {
        return beerSales;
    }

    public void setBeerSales(double beerSales) {
        this.beerSales = beerSales;
    }

    public double getWineSales() {
        return wineSales;
    }

    public void setWineSales(double wineSales) {
        this.wineSales = wineSales;
    }

    public double getLiquorSales() {
        return liquorSales;
    }

    public void setLiquorSales(double liquorSales) {
        this.liquorSales = liquorSales;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public boolean isPodLeader() {
        return isPodLeader;
    }

    public void setPodLeader(boolean podLeader) {
        isPodLeader = podLeader;
    }

    public boolean isRegionalManager() {
        return isRegionalManager;
    }

    public void setRegionalManager(boolean regionalManager) {
        isRegionalManager = regionalManager;
    }

    public boolean isSalesManager() {
        return isSalesManager;
    }

    public void setSalesManager(boolean salesManager) {
        isSalesManager = salesManager;
    }
}
