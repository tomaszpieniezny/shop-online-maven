package com.shop.shoponline.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "Product_Id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @NotNull
    @Column(name = "Price")
    private BigDecimal price;

    @NotNull
    @Column(name = "Stock")
    private int stock;

    public Product(String name, BigDecimal price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(int id, String name, String description, BigDecimal price, int stock) {
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "productList")
    public List<Orders> ordersList;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "productList")
    public List<ShoppingCart> shoppingCartList;

}
