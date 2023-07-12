package com.poly.shop.repository;

import com.poly.shop.entity.SanPhamCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamCTRepository extends JpaRepository<SanPhamCT,Long> {
    @Query("select c from SanPhamCT c where c.sanPham.id = :id")
    List<SanPhamCT> findAllBySpId(Long id);
}
