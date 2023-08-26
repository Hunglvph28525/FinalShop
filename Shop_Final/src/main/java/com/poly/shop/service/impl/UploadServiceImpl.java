package com.poly.shop.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.poly.shop.entity.Image;
import com.poly.shop.repository.ImageRepository;
import com.poly.shop.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private ImageRepository repository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile file, Long id) {
        try {
            Map req = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));

        String urlImg = (String) req.get("secure_url");
        Image image = new Image(urlImg, id);
        repository.save(image);
        return "thành công";
        } catch (IOException e) {
        e.printStackTrace();
    }
        return "Thất bại";
    }

    @Override
    public String uploadFile(MultipartFile file) {
        return null;
    }
}
