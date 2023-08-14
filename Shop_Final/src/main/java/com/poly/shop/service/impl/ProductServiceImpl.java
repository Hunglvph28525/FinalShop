package com.poly.shop.service.impl;

import com.poly.shop.dto.ProductModel;
import com.poly.shop.repository.ImageRepository;
import com.poly.shop.repository.ProductRepository;
import com.poly.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public List<ProductModel> getAll() {
        List<ProductModel> list = repository.getAll();
        list.stream().forEach(x -> x.setImages(imageRepository.findByProduct(x.getId())));
        return list;
    }

    @Override
    public List<ProductModel> getByBrand() {
        return null;
    }

    @Override
    public List<ProductModel> getByCategory() {
        return null;
    }
}
