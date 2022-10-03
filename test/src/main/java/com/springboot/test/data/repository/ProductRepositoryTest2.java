package com.springboot.test.data.repository;


import com.springboot.test.data.entity.Product;



import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepositoryTest2 {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void basicCRUDTest() {
        /* create */
        //given
        Product givenProduct = Product.builder().name("name").price(1000).stock(2000).build();

        //when
        Product saveProduct = productRepository.save(givenProduct);

        //then
        Assertions.assertThat(saveProduct.getNumber()).isEqualTo(givenProduct.getNumber());
        Assertions.assertThat(saveProduct.getName()).isEqualTo(givenProduct.getName());
        Assertions.assertThat(saveProduct.getPrice()).isEqualTo(givenProduct.getPrice());
        Assertions.assertThat(saveProduct.getStock()).isEqualTo(givenProduct.getStock());

        /* read */
        //when
        Product selectProduct = productRepository.findById(saveProduct.getNumber()).orElseThrow(RuntimeException::new);

        //then
        Assertions.assertThat(selectProduct.getNumber()).isEqualTo(givenProduct.getNumber());
        Assertions.assertThat(selectProduct.getName()).isEqualTo(givenProduct.getName());
        Assertions.assertThat(selectProduct.getPrice()).isEqualTo(givenProduct.getPrice());
        Assertions.assertThat(selectProduct.getStock()).isEqualTo(givenProduct.getStock());

        /*update*/
        //when
        Product foundProduct = productRepository.findById(selectProduct.getNumber()).orElseThrow(RuntimeException::new);

        foundProduct.setName("장난감");

        Product updateProduct = productRepository.save(foundProduct);

        //then
        assertEquals(updateProduct.getName(), "장난감");

        /*delete*/
        productRepository.delete(updateProduct);

        //then
        assertFalse(productRepository.findById(selectProduct.getNumber()).isPresent());
    }
}
