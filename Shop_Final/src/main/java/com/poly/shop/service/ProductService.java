package com.poly.shop.service;

import com.poly.shop.dto.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel> getAll();
    List<ProductModel> getByBrand();
    List<ProductModel> getByCategory();

}
