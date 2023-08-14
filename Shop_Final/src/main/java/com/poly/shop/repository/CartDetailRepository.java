package com.poly.shop.repository;

import com.poly.shop.entity.CartDetail;
import com.poly.shop.entity.composite.CartDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, CartDetailId> {
}
