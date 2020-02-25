package com.shop.shoponline.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "User_Account")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Account_Id", unique = true)
    private int id;

    @NotNull
    @Column(name = "Login")
    private String login;

    @NotNull
    @Column(name = "Password")
    private String password;

    public UserAccount(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserAccount(int id, String login, String password) {
    }
}
