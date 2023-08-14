package com.poly.shop.repository;

import com.poly.shop.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Long> {
    @Query("select c from ProductDetail c where c.product.id = :id and c.status = true ")
    List<ProductDetail> findAllBySpId(Long id);
}
