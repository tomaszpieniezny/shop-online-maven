package com.shop.shoponline.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Delivery_Detail")
public class DeliveryDetail {

    @Id
    @Column(name = "Delivery_Detail_Id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "City")
    private String city;

    @NotNull
    @Column(name = "Street")
    private String street;

    @NotNull
    @Column(name = "Postcode")
    private String postcode;

    @NotNull
    @Column(name = "House_Number")
    private String houseNumber;

    public DeliveryDetail(String city, String street, String postcode, String houseNumber) {
        this.city = city;
        this.street = street;
        this.postcode = postcode;
        this.houseNumber = houseNumber;
    }


    public DeliveryDetail(int id, String street, String city, String postcode, String houseNumber) {
    }
}
