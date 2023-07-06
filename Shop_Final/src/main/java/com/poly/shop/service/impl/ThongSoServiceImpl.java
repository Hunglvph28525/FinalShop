package com.poly.shop.service.impl;

import com.poly.shop.entity.ThongSo;
import com.poly.shop.repository.ThongSoRepository;
import com.poly.shop.service.ThongSoService;
import org.springframework.beans.factory.annotation.Autowired;

public class ThongSoServiceImpl implements ThongSoService {
    @Autowired
    private ThongSoRepository repository;

    @Override
    public ThongSo getThongSo(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public ThongSo create(ThongSo thongSo) {
        return repository.save(thongSo);
    }

    @Override
    public ThongSo update(ThongSo thongSo, Long id) {
        thongSo.setId(id);
        return repository.save(thongSo);
    }

    @Override
    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
