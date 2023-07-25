package com.poly.shop.repository;

import com.poly.shop.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long> {
    NguoiDung findByUsername(String username);
}
