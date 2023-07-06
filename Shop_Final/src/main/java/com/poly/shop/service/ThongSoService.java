package com.poly.shop.service;


import com.poly.shop.entity.ThongSo;

public interface ThongSoService {
    ThongSo getThongSo(Long id);

    ThongSo create(ThongSo thongSo);

    ThongSo update(ThongSo thongSo, Long id);

    boolean delete(Long id);
}
