package com.poly.shop.service.impl;

import com.poly.shop.dto.ProductDetailDto;
import com.poly.shop.dto.ProductRequestDto;
import com.poly.shop.dto.VersionDto;
import com.poly.shop.entity.Colors;
import com.poly.shop.entity.Product;
import com.poly.shop.entity.ProductDetail;
import com.poly.shop.entity.Specification;
import com.poly.shop.entity.Storage;
import com.poly.shop.repository.ColorsRepository;
import com.poly.shop.repository.ImageRepository;
import com.poly.shop.repository.ProductDetailRepository;
import com.poly.shop.repository.ProductRepository;
import com.poly.shop.repository.StorageRepository;
import com.poly.shop.service.ProductDetailService;
import com.poly.shop.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ColorsRepository colorsRepository;
    @Autowired
    private StorageRepository storageRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private UploadService uploadService;
    @Override
    public ProductDetailDto getDetail(Long id, String rom) {
        ProductDetail detail = productDetailRepository.getProductDetail(id,rom).get(0);
        VersionDto versionDto = new VersionDto();
        versionDto.setColors(colorsRepository.getColorByProductId(id,rom));
        versionDto.setStorages(storageRepository.getStogareByProductId(id));
        ProductDetailDto detailDto = new ProductDetailDto(
                detail.getId(),
                detail.getProduct().getName(),
                detail.getProduct().getPrice(),
                detail.getProduct().getDescription(),
                detail.getProduct().getSpecification());
        detailDto.setImages(imageRepository.findByProduct(id));
        detailDto.setVersionDto(versionDto);
        return detailDto;
    }

    @Override
    public ProductDetailDto save(ProductRequestDto requestDto) throws IOException {
        Product product = new Product();
        product.setName(requestDto.getName());
        product.setPrice(requestDto.getPrice());
        product.setDescription(requestDto.getDescription());
        product.setSpecification(new Specification(requestDto));
        product = productRepository.save(product);
        ProductDetail detail = new ProductDetail();
        detail.setProduct(product);
        detail.setPrice(requestDto.getPrice());
        detail.setQuantity(requestDto.getQuantity());
        detail.setColor(new Colors(requestDto.getColor()));
        detail.setStorage(new Storage(requestDto.getStorage()));
        detail.setWarranty(requestDto.getWarranty());
        detail.setStatus(detail.getQuantity()>1?true:false);
        return new ProductDetailDto(productDetailRepository.save(detail));
    }

}
