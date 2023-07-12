package com.poly.shop.repository;

import com.poly.shop.entity.BoNho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoNhoRepositiry extends JpaRepository<BoNho,Long> {
}
