package com.poly.shop.service;

import com.poly.shop.entity.MauSac;

import java.util.List;

public interface MauSacService {
    List<MauSac> getAll();

    MauSac getBoNho(Long id);

    void delete(Long id);

    MauSac create(MauSac mauSac);

    MauSac update(MauSac mauSac, Long id);
}
