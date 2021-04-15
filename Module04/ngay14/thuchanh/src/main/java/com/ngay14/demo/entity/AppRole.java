package com.ngay14.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "App_Role",uniqueConstraints ={
        @UniqueConstraint(name = "APP_ROLE_UK",columnNames = "Role_Name")
})
public class AppRole {
    @Id
    @GeneratedValue
    @Column(name = "Role_Id",nullable = false)
    private long roleId;

    @Column(name = "Role_Name", length = 30, nullable = false)
    private String roleName;

    @OneToMany(mappedBy = "appRole", cascade = CascadeType.ALL)
    @JsonBackReference(value = "UserAppRole")
    private Set<UserRole> userRoles;
    public AppRole() {
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
