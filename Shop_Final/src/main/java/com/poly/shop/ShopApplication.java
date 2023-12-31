package com.poly.shop;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);

    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloud = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dg8hhxkah",
                "api_key", "689858737754194",
                "api_secret", "_Bjo7wwguxDZt9DiZ882PLuox10",
                "secure",true));
        return cloud ;
    }
}




