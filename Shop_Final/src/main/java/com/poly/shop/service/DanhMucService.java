package com.poly.shop.service;

import com.poly.shop.entity.DanhMuc;

import java.util.List;

public interface DanhMucService {
    List<DanhMuc> getAll();

    DanhMuc getDanhMucById(Long id);

    DanhMuc create(DanhMuc danhMuc);

    DanhMuc update(DanhMuc danhMuc, Long id);

    boolean delete(Long id);
}
