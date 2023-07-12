package com.poly.shop.service.impl;

import com.poly.shop.entity.MauSac;
import com.poly.shop.repository.MauSacRepository;
import com.poly.shop.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository repository;

    @Override
    public List<MauSac> getAll() {
        return repository.findAll();
    }

    @Override
    public MauSac getBoNho(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public MauSac create(MauSac mauSac) {
        return repository.save(mauSac);
    }

    @Override
    public MauSac update(MauSac mauSac, Long id) {
        mauSac.setId(id);
        return repository.save(mauSac);
    }
}
