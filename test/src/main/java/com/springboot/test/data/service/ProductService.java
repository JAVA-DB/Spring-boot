package com.springboot.test.data.service;

import com.springboot.test.data.dto.ProductDto;
import com.springboot.test.data.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deletProduct(Long number) throws Exception;
}
