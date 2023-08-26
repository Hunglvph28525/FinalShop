package com.poly.shop.controller;

import com.poly.shop.model.ResponObject;
import com.poly.shop.service.ProductDetailService;
import com.poly.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("product")
    public ResponseEntity<ResponObject> getAllProduct() {
        return ResponseEntity.ok(new ResponObject("ok", "ok", productService.getAll()));
    }
    @GetMapping("product/{id}")
    public ResponseEntity<ResponObject> detailProduct(@PathVariable("id") Long id) {
        String rom = "128GB";
        return ResponseEntity.ok(new ResponObject("ok", "ok", productDetailService.getDetail(id,rom)));
    }
    @GetMapping("product/{id}/{rom}")
    public ResponseEntity<ResponObject> detailProduct( @PathVariable("id") Long id,@PathVariable(name = "rom", required = false) String rom) {
        if (rom == null){
            rom = "128GB";
        }
        return ResponseEntity.ok(new ResponObject("ok", "ok", productDetailService.getDetail(id,rom)));
    }
}
