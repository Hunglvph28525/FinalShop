package com.poly.shop.service.impl;

import com.poly.shop.entity.SanPhamCT;
import com.poly.shop.repository.SanPhamCTRepository;
import com.poly.shop.service.SanPhamCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamCTServiceImpl implements SanPhamCTService {
    @Autowired
    private SanPhamCTRepository repository;

    @Override
    public List<SanPhamCT> getAll() {
        return repository.findAll();
    }

    @Override
    public List<SanPhamCT> getListBySpID(Long id) {
        return repository.findAllBySpId(id);
    }

    @Override
    public SanPhamCT getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public SanPhamCT newOption(SanPhamCT sanPhamCT) {
        return repository.save(sanPhamCT);
    }

    @Override
    public void deleteOption(Long id) {
        repository.deleteById(id);
    }
}
