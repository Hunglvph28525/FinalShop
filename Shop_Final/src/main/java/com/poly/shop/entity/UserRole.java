package com.poly.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "USER_ROLE")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ID_USER",referencedColumnName = "ID")
    @JsonIgnore
    private NguoiDung nguoiDung;
    @ManyToOne
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID")
    @JsonIgnore
    private Roles roles;
}
