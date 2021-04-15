package com.ngay14.demo.repository;

import com.ngay14.demo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String username);
}
