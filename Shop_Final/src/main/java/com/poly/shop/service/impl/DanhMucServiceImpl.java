package com.poly.shop.service.impl;

import com.poly.shop.entity.DanhMuc;
import com.poly.shop.repository.DanhMucReposirory;
import com.poly.shop.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucServiceImpl implements DanhMucService {
    @Autowired
    private DanhMucReposirory reposirory;

    @Override
    public List<DanhMuc> getAll() {
        return reposirory.findAll();
    }

    @Override
    public DanhMuc getDanhMucById(Long id) {
        return reposirory.getReferenceById(id);
    }

    @Override
    public DanhMuc create(DanhMuc danhMuc) {

        return reposirory.save(danhMuc);
    }

    @Override
    public DanhMuc update(DanhMuc danhMuc, Long id) {
        danhMuc.setId(id);
        return reposirory.save(danhMuc);

    }

    @Override
    public boolean delete(Long id) {
        try {
            reposirory.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
