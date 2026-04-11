package org.example.application.product.dto;

import org.example.application.product.entity.Product;

public record ProductResponse (
    Long id,
    String name,
    int price,
    String quantity,
    String description
)
{
    public static ProductResponse from(Product product){
        return new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getQuantity(), product.getDescription());
    }

}
