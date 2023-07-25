package com.poly.shop.service.impl;

import com.poly.shop.entity.UserRole;
import com.poly.shop.repository.NguoiDungRepository;
import com.poly.shop.repository.RolesRepository;
import com.poly.shop.repository.UserRoleRepository;
import com.poly.shop.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    @Override
    public UserRole add(String Username, String roleName) {

        return userRoleRepository.save(new UserRole(null,nguoiDungRepository.findByUsername(Username),rolesRepository.findByTen(roleName)));
    }

    @Override
    public void delete(String Username, String roleName) {
        UserRole userRole = userRoleRepository.getUserRole(Username,roleName);
        userRoleRepository.delete(userRole);
    }
}
