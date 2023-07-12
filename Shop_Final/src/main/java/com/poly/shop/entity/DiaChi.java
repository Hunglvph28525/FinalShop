package com.poly.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table(name = "DIA_CHI")

public class DiaChi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "TINH")
    private String tinh;
    @Column(name = "QUAN_HUYEN")
    private String quanHuyen;
    @Column(name = "PHUONG_XA")
    private String phuongXa;
    @Column(name = "SO_NHA_DUONG")
    private String soNhaDuong;
    @OneToOne(mappedBy = "diaChi")
    @JsonIgnore
    private NguoiDung nguoiDung;
}
