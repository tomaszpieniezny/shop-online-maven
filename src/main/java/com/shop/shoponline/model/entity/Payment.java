package com.shop.shoponline.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Payment_Id", unique = true)
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "Method")
    private enumMethod method;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private enumStatus status;

    public enum enumMethod{
        TRANSFER, CREDIT_CART
    }

    public enum enumStatus{
        PAID, SEND, CANCELED, CONFIRMED, COMPLETED
    }

    public Payment(enumMethod method, enumStatus status) {
        this.method = method;
        this.status = status;
    }

    public Payment(int id, enumMethod enumMethod, enumStatus enumStatus) {

    }
}
