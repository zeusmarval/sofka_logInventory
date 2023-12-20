package com.zama.logsInventori.utils.Mappers;

import com.zama.logsInventori.Models.Product;

public class ProductMapper {

    public static Product toEntity(Product entity) {
        Product product = new Product();
        product.setName(entity.getName());
        product.setQuantity(entity.getQuantity());
        product.setSubtotal(entity.getSubtotal());
        product.setBasePrice(entity.getBasePrice());
        product.setWholesaleUnits(entity.getWholesaleUnits());
        return product;
    }

}
