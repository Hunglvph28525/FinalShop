package com.poly.shop.dto;

import com.poly.shop.entity.Colors;
import com.poly.shop.entity.Storage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VersionDto {
    private List<Storage> storages;
    private List<Colors> colors;

}
