package com.poly.shop.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table(name = "NGUOI_DUNG")
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "TEN")
    private String ten;
    @Column(name = "GIOI_TINH")
    private Boolean gioiTinh;
    @Column(name = "url_avt")
    private String urlAvt;
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "GMAIL")
    private String email;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "DIA_CHI",referencedColumnName = "ID")
    private DiaChi diaChi;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROLE")
    private Boolean role;
}
