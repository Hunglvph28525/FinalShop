package com.poly.shop.controller;

import com.poly.shop.entity.SanPham;
import com.poly.shop.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamService service;

    @GetMapping
    public ResponseEntity<List<SanPham>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SanPham> getSanPham(@PathVariable("id") Long id) {
        Optional<SanPham> optional = service.getSanPhamById(id);
        if (optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SanPham> createSanPham(@RequestBody SanPham sanPham) {
//        if (service.check(sanPham.getId())) {
//            return ResponseEntity.badRequest().build();
//        }
        return ResponseEntity.ok(service.create(sanPham));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SanPham> updateSanPham(@PathVariable("id") Long id, @RequestBody SanPham sanPham) {
        sanPham.setId(id);
        if (service.check(id)){
            return ResponseEntity.ok(service.create(sanPham));
        }
            return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSanPham(@PathVariable("id") Long id){
        if (service.check(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
