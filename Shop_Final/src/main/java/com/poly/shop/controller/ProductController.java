package com.poly.shop.controller;

import com.poly.shop.entity.Product;
import com.poly.shop.model.ResponObject;
import com.poly.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("product")
    public ResponseEntity<ResponObject> getAllProduct() {
        return ResponseEntity.ok(new ResponObject("ok","ok",productService.getAll()));
    }
}
