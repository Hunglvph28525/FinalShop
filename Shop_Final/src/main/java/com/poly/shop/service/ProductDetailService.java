package com.poly.shop.service;

import com.poly.shop.dto.ProductDetailDto;
import com.poly.shop.dto.ProductRequestDto;

import java.io.IOException;
import java.util.List;


public interface ProductDetailService {
    ProductDetailDto getDetail(Long id, String rom);
    ProductDetailDto save(ProductRequestDto requestDto) throws IOException;
}
