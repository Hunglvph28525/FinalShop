package com.poly.shop.service;

import com.poly.shop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();
    List<ProductDto> getByBrand(Long id);
    List<ProductDto> getByCategory(Long id);

}
