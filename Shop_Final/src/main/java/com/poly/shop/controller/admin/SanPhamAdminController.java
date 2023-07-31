package com.poly.shop.controller.admin;

import com.poly.shop.entity.SanPham;
import com.poly.shop.entity.SanPhamCT;
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
@RequestMapping("/admin/api/product")
public class SanPhamAdminController {

    @Autowired
    private SanPhamService service;
    @Autowired
    private SanPhamCTService sanPhamCTService;

    @PostMapping
    public ResponseEntity<SanPham> createSanPham(@RequestBody SanPhamModel sanPhamModel) {
//        if (service.check(sanPham.getId())) {
//            return ResponseEntity.badRequest().build();
//        }
        SanPham sanPham = new SanPham();
        sanPham.setTen(sanPhamModel.getTenSP());
        sanPham.setDanhMuc(sanPhamModel.getDanhMuc());
        sanPham.setGia(sanPhamModel.getGia());
        sanPham.setMota(sanPhamModel.getMota());
        sanPham.setThongSo(sanPhamModel.getThongSo());
        sanPham.setThuongHieu(sanPhamModel.getThuongHieu());
        sanPham = service.create(sanPham);
        System.out.println(sanPham.toString());
        SanPhamCT sanPhamCT = new SanPhamCT();
        sanPhamCT.setSanPham(sanPham);
        sanPhamCT.setBaoHanh(sanPhamModel.getBaoHanh());
        sanPhamCT.setMauSac(sanPhamModel.getMauSac());
        sanPhamCT.setGia(sanPhamModel.getGia());
        sanPhamCT.setSoLuong(sanPhamModel.getSoLuong());
        sanPhamCT.setTrangThai(sanPhamModel.isTrangThai());
        sanPhamCTService.newOption(sanPhamCT);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SanPham> updateSanPham(@PathVariable("id") Long id, @RequestBody SanPham sanPham) {
        sanPham.setId(id);
        if (service.check(id)) {

            return ResponseEntity.ok(service.create(sanPham));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSanPham(@PathVariable("id") Long id) {
        if (service.check(id)) {
            service.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }


    @PostMapping("/newOption/{id}")
    public ResponseEntity<SanPhamCT> newOption(@RequestBody SanPhamCT sanPhamCT, @PathVariable("id") Long id) {
        SanPham sanPham = service.getSanPhamById(id).get();
        sanPhamCT.setSanPham(sanPham);
        return ResponseEntity.ok(sanPhamCTService.newOption(sanPhamCT));
    }
    @GetMapping("test")
    ResponseEntity<List<SanPham>> test(){
        List<SanPham> list = service.getAll();
        return ResponseEntity.ok(list);
    }
}
