package com.poly.shop.controller;

import com.poly.shop.entity.SanPham;
import com.poly.shop.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamService service;

    @GetMapping
    public List<SanPham> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SanPham getSanPham(@PathVariable("id") Long id) {
        return service.getSanPhamById(id);
    }

    @PostMapping
    public SanPham createSanPham(@RequestBody SanPham sanPham) {
        System.out.println(sanPham.toString());
        return service.create(sanPham);
    }

    @PutMapping("/{id}")
    public SanPham updateSanPham(@PathVariable("id") Long id, @RequestBody SanPham sanPham) {
        System.out.println(sanPham.toString());
        return service.update(sanPham, id);
    }
    @DeleteMapping("/{id}")
    public void deleteSanPham(@PathVariable("id") Long id){
        service.delete(id);
    }
}
