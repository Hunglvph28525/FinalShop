package com.poly.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequestDto {
    private String name;
    private Double price;
    private String description;
    private String screen;
    private String os;
    private String cpu;
    private String camera;
    private String battery;
    private Long color;
    private Long storage;
    private Integer quantity;
    private String warranty;
}
