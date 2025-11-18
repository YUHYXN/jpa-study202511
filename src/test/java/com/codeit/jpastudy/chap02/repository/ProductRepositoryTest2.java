package com.codeit.jpastudy.chap02.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.codeit.jpastudy.chap02.entity.Product;
import com.codeit.jpastudy.chap02.entity.Product.Category;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
@Rollback(false)
class ProductRepositoryTest2 {

    private static final Logger log = LoggerFactory.getLogger(ProductRepositoryTest2.class);
    @Autowired
    ProductRepository productRepository;    // jpa가 구현체를 주입함

    @Test
    void saveTest() {

        Product p = Product.builder()
            .name("떡볶이")
            .price(3000)
            .category(Category.FOOD)
            .build();

        // INSERTGN 저장된 데이터의 객체 반환.
        Product saved = productRepository.save(p);  // .save() 많이씀
        System.out.println("saved = " + saved);

    }



    @Test
    @DisplayName("")
    void deleteTest() {
        // given (테스트에 사용하는 변수, 입력
        Long id = 2l;


        // when - 실행 (
        productRepository.deleteById(id);


        // then - (
        Optional<Product> byId = productRepository.findById(id);    // .findById() 많이씀
        System.out.println(byId.isPresent());


    }


    @Test
    @DisplayName("상품 전체 조회를 하면 개수가 2개여야 한다.")
    void selectAllTest() {
        // given


        // when
        List<Product> products = productRepository.findAll();   // .findAll() 많이씀

        // then
        products.forEach(System.out::println);

        Assertions.assertEquals(2, products.size());

    }

    @Test
    @DisplayName("3번 상품의 이름과 가격을 변경해야 한다.")
    void updateTest() {
        // given
        Long id = 3L;
        String newName = "삼겹살";
        int newPrice = 12000;

        // when
        Product product = productRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("상품이 존재하지 않습니다.")
        );

        product.setName(newName);
        product.setPrice(newPrice);

        // spring-data-jpa는 따로 UPDATE 메서드를 제공하지 않는다.
        // 조회한 객체의 필드를 변경하면 트랜잭션 종료 후 자동으로 UPDATE가 나간다. (Dirty Checking)
        // 가독성 때문에 save() 메서드를 작성하는 경우가 있다. 어차피 동작은 똑같다.
        productRepository.save(product);

        // then


    }




}