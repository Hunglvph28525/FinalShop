package com.poly.shop.repository;

import com.poly.shop.entity.Ivoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IvoiceRepository extends JpaRepository<Ivoice,Long> {
}
