package com.ngay14.demo.repository;

import com.ngay14.demo.entity.AppUser;
import com.ngay14.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepo extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
