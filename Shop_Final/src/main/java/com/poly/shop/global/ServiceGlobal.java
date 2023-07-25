package com.poly.shop.global;

import com.poly.shop.service.NguoiDungService;
import com.poly.shop.service.RolesService;
import com.poly.shop.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceGlobal {

    @Autowired
    public NguoiDungService nguoiDungService;
    @Autowired
    public RolesService rolesService;
    @Autowired
    public UserRoleService userRoleService;

}
