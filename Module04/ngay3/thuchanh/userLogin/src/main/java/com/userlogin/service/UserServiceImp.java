package com.userlogin.service;

import com.userlogin.model.Login;
import com.userlogin.model.User;
import com.userlogin.repository.IUserRepoImp;
import com.userlogin.repository.UserRepoImp;

import java.util.List;

public class UserServiceImp implements IUserService {
    IUserRepoImp userRepoImp = new UserRepoImp();

    @Override
    public User checkLogin(Login login) {
        return userRepoImp.checkLogin(login);
    }
}
