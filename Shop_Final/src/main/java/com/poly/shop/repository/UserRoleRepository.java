package com.poly.shop.repository;

import com.poly.shop.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    @Query("select c from UserRole c where c.nguoiDung.username = :username and c.roles.ten = :ten")
    UserRole getUserRole(String username,String ten);

}
