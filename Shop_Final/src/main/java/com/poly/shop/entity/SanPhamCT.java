package com.poly.shop.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "SAN_PHAM_CT")
public class SanPhamCT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SAN_PHAM_ID",referencedColumnName = "ID")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MAU_SAC_ID",referencedColumnName = "ID")
    private MauSac mauSac;
    @Column(name = "GIA")
    private Double gia;
    @Column(name = "SO_LUONG")
    private Integer soLuong;
    @Column(name = "BAO_HANH")
    private String baoHanh;
    @Column(name = "TRANG_THAI")
    private Boolean trangThai;

}
