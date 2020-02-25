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
        return userAccountDao.save(userAccount);
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
