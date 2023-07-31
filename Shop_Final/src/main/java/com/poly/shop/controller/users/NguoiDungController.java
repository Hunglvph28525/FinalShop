package com.poly.shop.controller.users;

import com.poly.shop.entity.NguoiDung;
import com.poly.shop.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/nguoi-dung")
public class NguoiDungController {
    @Autowired
    private NguoiDungService service;

    @GetMapping("")
    ResponseEntity<List<NguoiDung>> getAll(){
        return ResponseEntity.ok(service.getAll());
    };

    @PostMapping("/dangky")
    ResponseEntity<NguoiDung> dangKiTK(){
        return null;
    }
}
