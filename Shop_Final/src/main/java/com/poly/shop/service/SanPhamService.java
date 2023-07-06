package com.poly.shop.service;

import com.poly.shop.entity.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> getAll();

    SanPham getSanPhamById(Long id);

    SanPham create(SanPham sanPham);

    SanPham update(SanPham sanPham, Long id);

    boolean delete(Long id);
}
