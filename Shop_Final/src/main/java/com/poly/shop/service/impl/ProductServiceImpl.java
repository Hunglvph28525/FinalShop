package com.poly.shop.service.impl;

import com.poly.shop.dto.ProductDto;
import com.poly.shop.entity.Image;
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
    public List<ProductDto> getAll() {
        List<ProductDto> list = repository.getAll();
        list.stream().forEach(x -> {
            Image image = imageRepository.findByProduct(x.getId()).stream().findFirst().orElse(null);
            if (image != null) {
                x.setImages(image.getUrlImg());
            } else {
                x.setImages(null);
            }
        });

        return list;
    }

    @Override
    public List<ProductDto> getByBrand(Long id) {
        return repository.getAllByBrand(id);
    }

    @Override
    public List<ProductDto> getByCategory(Long id) {
        return repository.getAllByCategory(id);
    }
}
