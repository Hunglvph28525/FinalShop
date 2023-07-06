package com.poly.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "THONG_SO")
public class ThongSo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "MAN_HINH")
    private String manHinh;
    @Column(name = "HE_DIEU_HANH")
    private String heDieuHanh;
    @Column(name = "CPU")
    private String cpu;
    @Column(name = "CAMERA")
    private String camera;
    @Column(name = "PIN_SAC")
    private String pinSac;
    @OneToOne(mappedBy = "thongSo")
    private SanPham sanPham;

}
