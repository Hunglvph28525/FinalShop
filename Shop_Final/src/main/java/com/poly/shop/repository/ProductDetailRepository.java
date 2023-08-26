package com.poly.shop.repository;

import com.poly.shop.dto.ProductDetailDto;
import com.poly.shop.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Long> {
    @Query("SELECT c from ProductDetail c join Storage a " +
            "on c.storage.id = a.id where c.product.id = :id and c.storage.rom = :rom")
    List<ProductDetail> getProductDetail(Long id,String rom);
}
