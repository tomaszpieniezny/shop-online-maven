package com.shop.shoponline.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @Column(name = "Orders_Id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Date_Of_Payment")
    private LocalDate dateOfPayment;

    @NotNull
    @Column(name = "Date_Of_Order")
    private LocalDate dateOfOrder;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private enumOrderStatus status;

    public enum enumOrderStatus{
        FINISHED, DURING, STARTED
    }

    public Orders(LocalDate dateOfOrder, enumOrderStatus status) {
        this.dateOfOrder = dateOfOrder;
        this.status = status;
    }

    public Orders(int id, LocalDate dateOfPayment, LocalDate dateOfOrder, enumOrderStatus status) {
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Join_Product_Order",
            joinColumns = {
                    @JoinColumn(name = "Orders_Id", referencedColumnName = "Orders_Id")
            }, inverseJoinColumns = {
            @JoinColumn(name = "Product_Id", referencedColumnName = "Product_Id")
    }
    )
    public List<Product> productList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Delivery_Detail_Id")
    public DeliveryDetail deliveryDetail;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Payment_Id")
    public Payment payment;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "User_Id")
    public User user;

}
