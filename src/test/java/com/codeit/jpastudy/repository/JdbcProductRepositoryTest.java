package com.codeit.jpastudy.repository;

import com.codeit.jpastudy.chap01.entity.Product;
import com.codeit.jpastudy.chap01.entity.Product.Category;
import com.codeit.jpastudy.chap01.repository.JdbcProductRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JdbcProductRepositoryTest {

    @Autowired
    JdbcProductRepository repository;

    @Test
    void insertTest() {
        repository.insertProduct("맥북", 1000000, Category.ELECTRONIC);
    }

    @Test
    void selectAllTest() {
        List<Product> products = repository.selectAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

}