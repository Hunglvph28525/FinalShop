package com.poly.shop.repository;

import com.poly.shop.entity.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucReposirory extends JpaRepository<DanhMuc,Long> {
}
