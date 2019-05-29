package net.retail.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public boolean isGroceries() {
        return isGroceries;
    }

    public void setGroceries(boolean groceries) {
        isGroceries = groceries;
    }

    private String productName;
    private double unitPrice;
    private int units;
    @JsonProperty
    private boolean isGroceries;
}
