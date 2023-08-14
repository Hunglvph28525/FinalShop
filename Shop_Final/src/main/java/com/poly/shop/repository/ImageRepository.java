package com.poly.shop.repository;

import com.poly.shop.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query("select c from Image c where c.product.id =:id")
    List<Image> findByProduct(Long id);
}
