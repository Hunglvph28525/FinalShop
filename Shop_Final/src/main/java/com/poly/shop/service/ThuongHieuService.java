package com.poly.shop.service;

import com.poly.shop.entity.ThuongHieu;

import java.util.List;

public interface ThuongHieuService {
    List<ThuongHieu> getAll();

    ThuongHieu getSanPhamById(Long id);

    ThuongHieu create(ThuongHieu thuongHieu);

    ThuongHieu update(ThuongHieu thuongHieu, Long id);

    boolean delete(Long id);


}
