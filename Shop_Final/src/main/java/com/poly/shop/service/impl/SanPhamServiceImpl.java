package com.poly.shop.service.impl;

import com.poly.shop.entity.SanPham;
import com.poly.shop.repository.SanPhamRepository;
import com.poly.shop.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository repository;

    @Override
    public List<SanPham> getAll() {
        return repository.findAll();
    }

    @Override
    public SanPham getSanPhamById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public SanPham create(SanPham sanPham) {
        return repository.save(sanPham);
    }

    @Override
    public SanPham update(SanPham sanPham, Long id) {
        sanPham.setId(id);
        return repository.save(sanPham);
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
