package com.poly.shop.repository;

import com.poly.shop.dto.ProductDto;
import com.poly.shop.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT new com.poly.shop.dto.ProductDto(c.id,c.name,c.price)" +
            "FROM Product c join ProductDetail a on c.id = a.product.id " +
            "group by c.id,c.name,c.price")
    List<ProductDto> getAll();
    @Query("SELECT new com.poly.shop.dto.ProductDto(c.id,c.name,c.price)" +
            "FROM Product c join ProductDetail a on c.id = a.product.id " +
            "group by c.id,c.name,c.price having c.brand.id =:id")
    List<ProductDto> getAllByBrand(Long id);
    @Query("SELECT new com.poly.shop.dto.ProductDto(c.id,c.name,c.price)" +
            "FROM Product c join ProductDetail a on c.id = a.product.id " +
            "group by c.id,c.name,c.price having c.categorys.id =:id")
    List<ProductDto> getAllByCategory(Long id);
}
