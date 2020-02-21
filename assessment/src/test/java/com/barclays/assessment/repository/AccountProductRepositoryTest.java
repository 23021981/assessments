package com.barclays.assessment.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AccountProductRepositoryTest {

    @Autowired
    AccountProductRepository accountProductRepository;

    @Test
    public void testAddAccountProduct(){
        assertTrue(accountProductRepository.findById("WA001").isPresent());
        assertEquals("Cash",accountProductRepository.findById("WA001").get().getProductName());
    }

}
