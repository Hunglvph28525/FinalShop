package com.poly.shop.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "storage")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ram",length = 20,nullable = false)
    private String ram;
    @Column(name = "rom",length = 20,nullable = false)
    private String rom;
    @OneToMany(mappedBy = "storage", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductDetail> productDetail;

    public Storage(Long id) {
        this.id = id;
    }
}