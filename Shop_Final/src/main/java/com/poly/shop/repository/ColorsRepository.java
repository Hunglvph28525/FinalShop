package com.poly.shop.repository;


import com.poly.shop.entity.Colors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorsRepository extends JpaRepository<Colors,Long> {
    @Query("select c from Colors c join ProductDetail a on c.id = a.color.id where a.product.id =:id and a.storage.rom =:rom and a.status = true ")
    List<Colors> getColorByProductId(Long id,String rom);
}
