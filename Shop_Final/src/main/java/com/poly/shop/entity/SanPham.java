package com.poly.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "SAN_PHAM")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class SanPham {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TEN")
    private String ten;

    @OneToOne (fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "THONG_SO_ID",referencedColumnName = "ID")
    @JsonProperty("thongSo")
    private ThongSo thongSo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DANH_MUC_id",referencedColumnName = "ID")
    @JsonIgnoreProperties(value = {"sanPhams"}, allowSetters = true)
    private DanhMuc danhMuc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THUONG_HIEU_ID",referencedColumnName = "ID")
    @JsonIgnoreProperties(value = {"sanPhams"}, allowSetters = true)
    private ThuongHieu thuongHieu;

    @Column(name = "GIA")
    private Double gia;

    @Column(name = "MOTA")
    private String mota;

}
