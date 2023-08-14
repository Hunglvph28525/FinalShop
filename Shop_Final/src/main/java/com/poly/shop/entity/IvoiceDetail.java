package com.poly.shop.entity;


import com.poly.shop.entity.composite.IvoiceDetailId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "ivoice_detail")
public class IvoiceDetail {
    @EmbeddedId
    private IvoiceDetailId ivoiceDetailId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;
}
