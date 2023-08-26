package com.poly.shop.controller;

import com.poly.shop.dto.ProductRequestDto;
import com.poly.shop.model.ResponObject;
import com.poly.shop.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {
    @Autowired
    private ProductDetailService productDetailService;

    @PostMapping("product/new")
    public ResponseEntity<ResponObject> creatProduct(@RequestBody ProductRequestDto requestDto) throws IOException {
        return ResponseEntity.ok(new ResponObject("ok","ok",productDetailService.save(requestDto)));
    }
}
