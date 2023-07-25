package com.poly.shop.service;

import com.poly.shop.entity.UserRole;

public interface UserRoleService {
    UserRole add(String Username,String roleName);
    void delete(String Username,String roleName);
}
