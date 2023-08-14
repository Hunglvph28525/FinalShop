package com.poly.shop.repository;

import com.poly.shop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartReposotory extends JpaRepository<Cart,Long> {
}
