package com.poly.shop.dto;

import com.poly.shop.entity.Image;
import com.poly.shop.entity.Specification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ProductModel {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Specification specification;
    private List<Image> images;

    public ProductModel(Long id, String name, Double price, String description,Specification specification) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.specification = specification;
    }
}
