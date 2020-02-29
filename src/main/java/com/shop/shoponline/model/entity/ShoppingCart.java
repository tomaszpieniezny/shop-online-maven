package com.shop.shoponline.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Shopping_Cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Shopping_Cart_Id", unique = true)
    private int id;

    @NotNull
    @Column(name = "Quantity")
    private long quantity;

    public ShoppingCart(long quantity) {
        this.quantity = quantity;
    }

    public ShoppingCart (int id, long quantity) {

    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Join_Product_Shopping_Cart",
            joinColumns = {
                    @JoinColumn(name = "Shopping_Cart_Id", referencedColumnName = "Shopping_Cart_Id")
            }, inverseJoinColumns = {
            @JoinColumn(name = "Product_Id", referencedColumnName = "Product_Id")
    }
    )
    public List<Product> productList;
}
