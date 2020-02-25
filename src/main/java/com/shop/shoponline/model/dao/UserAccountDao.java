package com.shop.shoponline.model.dao;

import com.shop.shoponline.model.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserAccountDao extends CrudRepository <UserAccount, Long> {

    @Override
    UserAccount save(UserAccount userAccount);

    List<UserAccount> findAll();

    Optional<UserAccount> findById(int id);

    void deleteById(final int id);
}
