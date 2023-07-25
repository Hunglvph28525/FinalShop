package com.poly.shop.service.impl;

import com.poly.shop.entity.Roles;
import com.poly.shop.repository.RolesRepository;
import com.poly.shop.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public void addRoles(Roles roles) {
        rolesRepository.save(roles);
    }
}
