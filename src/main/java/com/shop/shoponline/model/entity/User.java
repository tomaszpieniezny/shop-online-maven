package com.shop.shoponline.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id", unique = true)
    private int id;

    @NotNull
    @Column(name = "First_Name")
    private String firstName;

    @NotNull
    @Column(name = "Last_Name")
    private String lastName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private enumUserStatus status;

    public enum enumUserStatus{
        ADMIN, CUSTOMER
    }

    public User(String firstName, String lastName, enumUserStatus status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    public User(int id, String firstName, String lastName, enumUserStatus status) {
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "User_Account_Id")
    public UserAccount userAccount;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Shopping_Cart_Id")
    public ShoppingCart shoppingCart;

    @OneToMany(
            targetEntity = Orders.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    public List<Orders> ordersList;
}