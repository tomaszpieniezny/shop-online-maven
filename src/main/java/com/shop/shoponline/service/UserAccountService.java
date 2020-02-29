package com.shop.shoponline.service;

import com.shop.shoponline.model.dao.UserAccountDao;
import com.shop.shoponline.model.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountDao userAccountDao;

    public UserAccount saveUserAccount(final UserAccount userAccount) {
        if (userAccount.getLogin().matches("^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$") &
                userAccount.getPassword().matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?=\\\\S+$).{6,18}")) {
            return userAccountDao.save(userAccount);
        } else {
            throw new RuntimeException("Login or Password is not correct");
        }
    }
    public List<UserAccount> findAllUserAccount() {
        return userAccountDao.findAll();
    }
    public Optional<UserAccount> getUserAccount(final int id) {
        return userAccountDao.findById(id);
    }

    public void deleteUserAccount(final int id) {
        userAccountDao.deleteById(id);
    }
}
