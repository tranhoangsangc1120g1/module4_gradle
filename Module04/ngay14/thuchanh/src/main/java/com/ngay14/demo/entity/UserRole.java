package com.ngay14.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "User_Role",uniqueConstraints = {
@UniqueConstraint(name = "USER_ROLE_UK",columnNames = { "User_Id", "Role_Id" })
})
public class UserRole {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private AppRole appRole;

    @ManyToOne
    @JoinColumn(name = "Role_Id", nullable = false)
    private AppUser appUser;


    public UserRole() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
