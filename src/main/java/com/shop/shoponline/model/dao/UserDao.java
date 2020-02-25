package com.shop.shoponline.model.dao;

import com.shop.shoponline.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserDao extends CrudRepository <User, Long> {

    @Override
    User save(User user);

    List<User> findAll();

    Optional<User> findById(int id);

    void deleteById(int id);
}
