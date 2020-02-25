package com.shop.shoponline.service;

import com.shop.shoponline.model.dao.ProductDao;
import com.shop.shoponline.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> findAllProduct() {
        return productDao.findAll();
    }

    public List<Product> findAllAvailableProduct() {
        return productDao.findAll().stream()
                .filter(product -> product.getStock()>0)
                .collect(Collectors.toList());
    }

    public Optional<Product> getProduct(final int id) {
        return productDao.findById(id);
    }

    public Product saveProduct(final Product product) {
        return productDao.save(product);
    }

    public void deleteProduct(final int id) {
        productDao.deleteById(id);
    }

}
