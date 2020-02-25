package com.shop.shoponline.service;

import com.shop.shoponline.model.dao.UserDao;
import com.shop.shoponline.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAllUsers () {
        return userDao.findAll();
    }
    public Optional<User> getUser (final int id) {
        return userDao.findById(id);
    }

    public User saveUser (final User user){
        return userDao.save(user);
    }

    public void deleteUser (final int id) {
        userDao.deleteById(id);
    }
}
