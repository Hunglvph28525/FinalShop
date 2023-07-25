package com.poly.shop.service;

import com.poly.shop.entity.NguoiDung;

import java.util.List;

public interface NguoiDungService {
    List<NguoiDung> getAll();

    NguoiDung getNguoiDungByUsername(String username);

    NguoiDung createNguoiDung(NguoiDung nguoiDung);

    NguoiDung updatenguoiDung(NguoiDung nguoiDung, Long id);

    void deleteNguoiDung(Long id);

}
