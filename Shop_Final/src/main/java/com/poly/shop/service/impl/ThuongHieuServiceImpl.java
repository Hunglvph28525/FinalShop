package com.poly.shop.service.impl;

import com.poly.shop.entity.ThuongHieu;
import com.poly.shop.repository.ThuongHieuRepository;
import com.poly.shop.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ThuongHieuServiceImpl implements ThuongHieuService {

    @Autowired
    private ThuongHieuRepository repository;

    @Override
    public List<ThuongHieu> getAll() {
        return repository.findAll();
    }

    @Override
    public ThuongHieu getSanPhamById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public ThuongHieu create(ThuongHieu thuongHieu) {
        return repository.save(thuongHieu);
    }

    @Override
    public ThuongHieu update(ThuongHieu thuongHieu, Long id) {
        thuongHieu.setId(id);
        return repository.save(thuongHieu);
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
