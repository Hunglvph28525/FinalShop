package com.poly.shop.service;

import com.poly.shop.entity.SanPham;

import java.util.List;
import java.util.Optional;

public interface SanPhamService {
    List<SanPham> getAll();

    Optional<SanPham> getSanPhamById(Long id);

    boolean check(Long id);

    SanPham create(SanPham sanPham);

    SanPham update(SanPham sanPham, Long id);

    boolean delete(Long id);
}
