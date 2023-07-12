package com.poly.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "SAN_PHAM")

@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class SanPham implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TEN")
    private String ten;

    @OneToOne (fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "THONG_SO_ID",referencedColumnName = "ID")
    private ThongSo thongSo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DANH_MUC_id",referencedColumnName = "ID")
    @JsonIgnore
    private DanhMuc danhMuc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THUONG_HIEU_ID",referencedColumnName = "ID")
    @JsonIgnore
    private ThuongHieu thuongHieu;

    @Column(name = "GIA")
    private Double gia;

    @Column(name = "MOTA")
    private String mota;

    @OneToMany(mappedBy = "sanPham",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SanPhamCT> sanPhamCTS;

}
