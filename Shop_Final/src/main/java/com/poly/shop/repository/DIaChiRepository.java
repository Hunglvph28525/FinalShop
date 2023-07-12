package com.poly.shop.repository;

import com.poly.shop.entity.DiaChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DIaChiRepository extends JpaRepository<DiaChi,Long> {
}
