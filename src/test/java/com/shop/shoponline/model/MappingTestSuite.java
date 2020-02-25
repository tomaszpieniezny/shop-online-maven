package com.shop.shoponline.model;

import com.shop.shoponline.model.dao.*;
import com.shop.shoponline.model.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MappingTestSuite {

    @Autowired
    OrdersDao ordersDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    DeliveryDetailDao deliveryDetailDao;

    @Autowired
    UserDao userDao;

    @Autowired
    UserAccountDao userAccountDao;

    @Test
    public void manyToManyTestSuit() {
        Orders orders1 = new Orders();
        orders1.setDateOfOrder(LocalDate.now());
        orders1.setStatus(Orders.enumOrderStatus.STARTED);

        DeliveryDetail deliveryDetail1 = new DeliveryDetail();
        deliveryDetail1.setCity("City Test1");
        deliveryDetail1.setPostcode("63720");
        deliveryDetail1.setStreet("Street Test1");
        deliveryDetail1.setHouseNumber("26");

        Payment payment1 = new Payment();
        payment1.setMethod(Payment.enumMethod.TRANSFER);
        payment1.setStatus(Payment.enumStatus.PAID);

        Product product1 = new Product();
        product1.setName("Produkt 1");
        product1.setPrice(new BigDecimal("2.6"));
        product1.setStock(3);

        Product product2 = new Product();
        product2.setName("Produkt 2");
        product2.setPrice(new BigDecimal("4353.75"));
        product2.setStock(765);

        User user1 = new User();
        user1.setFirstName("Tomek");
        user1.setLastName("Pieniezny");
        user1.setStatus(User.enumUserStatus.CUSTOMER);

        UserAccount userAccount1 = new UserAccount();
        userAccount1.setLogin("Tomek992");
        userAccount1.setPassword("haslo123");

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        orders1.setPayment(payment1);
        orders1.setDeliveryDetail(deliveryDetail1);
        orders1.setProductList(products);
        orders1.setUser(user1);

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setQuantity(34);
        shoppingCart1.setProductList(products);

        user1.setUserAccount(userAccount1);
        user1.setShoppingCart(shoppingCart1);


        ordersDao.save(orders1);
        productDao.save(product1);
        productDao.save(product2);
        deliveryDetailDao.save(deliveryDetail1);
        userDao.save(user1);
        userAccountDao.save(userAccount1);

    }
}
