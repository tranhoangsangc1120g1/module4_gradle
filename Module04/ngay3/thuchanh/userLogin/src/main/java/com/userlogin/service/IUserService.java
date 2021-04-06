package com.userlogin.service;

import com.userlogin.model.Login;
import com.userlogin.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
