package com.poly.shop.repository;

import com.poly.shop.entity.Categorys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorysReposirory extends JpaRepository<Categorys,Long> {
}
