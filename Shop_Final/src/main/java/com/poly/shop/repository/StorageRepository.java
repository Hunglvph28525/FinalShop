package com.poly.shop.repository;

import com.poly.shop.entity.Colors;
import com.poly.shop.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageRepository extends JpaRepository<Storage,Long> {
    @Query("select c from Storage c join ProductDetail a on c.id = a.storage.id where a.product.id =:id and a.status = true ")
    List<Storage> getStogareByProductId(Long id);
}
