package com.poly.shop.dto;

import com.poly.shop.entity.Image;
import com.poly.shop.entity.ProductDetail;
import com.poly.shop.entity.Specification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDetailDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Specification specification;
    private VersionDto versionDto;
    private List<Image> images;

    public ProductDetailDto(Long id, String name, Double price, String description, Specification specification) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.specification = specification;
    }
    public ProductDetailDto(ProductDetail x) {
        this.id = x.getId();
        this.name = x.getProduct().getName();
        this.price = x.getPrice();
        this.description = x.getProduct().getDescription();
        this.specification = x.getProduct().getSpecification();
    }

}
