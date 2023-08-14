package com.poly.shop.repository;

import com.poly.shop.entity.IvoiceDetail;
import com.poly.shop.entity.composite.IvoiceDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IvoiceDetailRepository extends JpaRepository<IvoiceDetail, IvoiceDetailId> {
}
