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
