package com.poly.shop.service;

import com.poly.shop.entity.BoNho;

import java.util.List;

public interface BoNhoService {
    List<BoNho> getAll();

    BoNho getBoNho(Long id);

    void delete(Long id);

    BoNho create(BoNho boNho);

    BoNho update(BoNho boNho, Long id);
}
