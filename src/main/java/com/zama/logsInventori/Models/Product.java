package com.zama.logsInventori.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private Integer quantity;
    private BigDecimal basePrice;
    private Integer wholesaleUnits;
    private BigDecimal subtotal;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public Integer getWholesaleUnits() {
        return wholesaleUnits;
    }

    public void setWholesaleUnits(Integer wholesaleUnits) {
        this.wholesaleUnits = wholesaleUnits;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Product(String name, Integer quantity, BigDecimal subtotal) {
        this.name = name;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", basePrice=" + basePrice +
                ", wholesaleUnit=" + wholesaleUnits +
                '}';
    }
}
