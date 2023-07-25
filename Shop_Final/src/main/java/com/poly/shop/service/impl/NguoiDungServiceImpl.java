package com.poly.shop.service.impl;

import com.poly.shop.entity.NguoiDung;
import com.poly.shop.repository.NguoiDungRepository;
import com.poly.shop.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

    @Autowired
    private NguoiDungRepository repository;

    @Override
    public List<NguoiDung> getAll() {
        return repository.findAll();
    }
    private PasswordEncoder passwordEncoder;

    @Override
    public NguoiDung getNguoiDungByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public NguoiDung createNguoiDung(NguoiDung nguoiDung) {
        nguoiDung.setPassword(passwordEncoder.encode(nguoiDung.getPassword()));
        return repository.save(nguoiDung);
    }

    @Override
    public NguoiDung updatenguoiDung(NguoiDung nguoiDung, Long id) {
        nguoiDung.setId(id);
        return repository.save(nguoiDung);
    }

    @Override
    public void deleteNguoiDung(Long id) {
        repository.deleteById(id);
    }
}
