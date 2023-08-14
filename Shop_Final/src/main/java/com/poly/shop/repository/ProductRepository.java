package com.poly.shop.repository;

import com.poly.shop.dto.ProductModel;
import com.poly.shop.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT new com.poly.shop.dto.ProductModel(c.id,c.name,c.price,c.description,a)FROM Product c JOIN Specification a\n" +
            "ON a.id = c.id")
    List<ProductModel> getAll();
}
