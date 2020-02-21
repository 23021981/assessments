package com.barclays.assessment.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void findProductTest(){
        assertTrue(productRepository.findById("PA1").isPresent());
        assertEquals(2, productRepository.findById("PA1").get().getRiskRating());
    }


}
