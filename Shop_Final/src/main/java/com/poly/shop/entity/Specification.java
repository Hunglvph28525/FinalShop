package com.poly.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "specification")
//Thông SỐ
public class Specification implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "screen",columnDefinition = ("nvarchar(255)"))
    private String screen;
    @Column(name = "os", columnDefinition = ("nvarchar(255)"))
    private String os;
    @Column(name = "cpu",columnDefinition = ("nvarchar(255)"))
    private String cpu;
    @Column(name = "camera",columnDefinition = ("nvarchar(255)"))
    private String camera;
    @Column(name = "battery",columnDefinition = ("nvarchar(255)"))
    private String battery;
    @JsonIgnore
    @OneToOne(mappedBy = "specification")
    private Product product;


}
