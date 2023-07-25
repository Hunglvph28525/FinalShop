package com.poly.shop.model;

import com.poly.shop.entity.DanhMuc;
import com.poly.shop.entity.MauSac;
import com.poly.shop.entity.ThongSo;
import com.poly.shop.entity.ThuongHieu;
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

public class SanPhamModel {
    private String tenSP;
    private ThongSo thongSo;
    private DanhMuc danhMuc;
    private ThuongHieu thuongHieu;
    private MauSac mauSac;

    private Double gia;
    private String mota;
    private Integer soLuong;
    private String baoHanh;
    private boolean trangThai;
}
