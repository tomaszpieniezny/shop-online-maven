package com.shop.shoponline.model.dao;

import com.shop.shoponline.model.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ProductDao extends CrudRepository<Product, Long> {

    List<Product> findAll();

    Optional<Product> findById(int id);

    void deleteById(int id);

    Product save(Product product);
}
