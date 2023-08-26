package com.poly.shop.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {
    String uploadFile(MultipartFile file,Long id) throws IOException;
    String uploadFile(MultipartFile file);
}
