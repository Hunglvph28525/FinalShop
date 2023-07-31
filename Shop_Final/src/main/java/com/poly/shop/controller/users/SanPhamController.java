package com.poly.shop.controller.users;

import com.poly.shop.entity.SanPham;
import com.poly.shop.entity.SanPhamCT;
import com.poly.shop.model.ResponObject;
import com.poly.shop.model.SanPhamModel;
import com.poly.shop.service.SanPhamCTService;
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

@RestController
@RequestMapping("/api/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamService service;
    @Autowired
    private SanPhamCTService sanPhamCTService;

    @GetMapping
    public ResponseEntity<List<SanPham>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponObject> getSanPham(@PathVariable("id") Long id) {
        List<SanPhamCT> list = sanPhamCTService.getListBySpID(id);
        if (list == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ResponObject("ok","done",list));
    }
}
