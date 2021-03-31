package com.userlogin.repository;

import com.userlogin.model.Login;
import com.userlogin.model.User;

public interface IUserRepoImp {
      User checkLogin(Login login);
}

