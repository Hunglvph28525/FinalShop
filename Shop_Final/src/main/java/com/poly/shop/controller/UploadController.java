package com.poly.shop.controller;

import com.poly.shop.model.ResponObject;
import com.poly.shop.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping("admin/upload/{id}")
    public ResponseEntity<ResponObject> uploadFile(@PathVariable("id") Long id, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        String response = uploadService.uploadFile(multipartFile,id);
        return ResponseEntity.ok(new ResponObject("ok", "ok", response));
    }
    @PostMapping("/upload")
    public ResponseEntity<ResponObject> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        String response = uploadService.uploadFile(multipartFile);
        return ResponseEntity.ok(new ResponObject("ok", "ok", response));
    }

}
