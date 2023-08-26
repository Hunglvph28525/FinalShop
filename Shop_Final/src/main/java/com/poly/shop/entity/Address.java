package com.poly.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "address")
@Embeddable
public class Address{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "province",columnDefinition = ("nvarchar(255)"))
    private String province;
    @Column(name = "district",columnDefinition = ("nvarchar(255)"))
    private String district;
    @Column(name = "ward",columnDefinition = ("nvarchar(255)"))
    private String ward;
    @Column(name = "street",columnDefinition = ("nvarchar(255)"))
    private String street;
}
