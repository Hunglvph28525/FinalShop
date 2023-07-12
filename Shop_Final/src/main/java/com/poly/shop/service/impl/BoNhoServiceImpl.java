package com.poly.shop.service.impl;

import com.poly.shop.entity.BoNho;
import com.poly.shop.repository.BoNhoRepositiry;
import com.poly.shop.service.BoNhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoNhoServiceImpl implements BoNhoService {
    @Autowired
    private BoNhoRepositiry repositiry;

    @Override
    public List<BoNho> getAll() {
        return repositiry.findAll();
    }

    @Override
    public BoNho getBoNho(Long id) {
        return repositiry.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        repositiry.deleteById(id);
    }

    @Override
    public BoNho create(BoNho boNho) {
        return repositiry.save(boNho);
    }

    @Override
    public BoNho update(BoNho boNho, Long id) {
        boNho.setId(id);
        return repositiry.save(boNho);
    }
}
