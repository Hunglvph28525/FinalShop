package com.poly.shop.service;

import com.poly.shop.entity.SanPhamCT;

import java.util.List;

public interface SanPhamCTService {
    List<SanPhamCT> getAll();
    List<SanPhamCT> getListBySpID(Long id);
    SanPhamCT getById(Long id);
    SanPhamCT newOption(SanPhamCT sanPhamCT);
    void deleteOption(Long id);
}
