package org.example.application.product.entity;
import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable= false)
    private int price;

    @Column(nullable = false)
    private String quantity;

    @Column(columnDefinition="TEXT")
    private String description;

    protected Product(){}

    public Product(String name, int price, String quantity, String description )
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;

    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;

    }

    public String getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

}
