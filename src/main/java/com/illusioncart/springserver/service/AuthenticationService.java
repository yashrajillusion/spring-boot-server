package com.illusioncart.springserver.service;

import com.illusioncart.springserver.model.User;
import com.illusioncart.springserver.model.requset.LoginReq;

public interface AuthenticationService {
    public String register(User user) throws Exception;

    public String login(LoginReq user) throws Exception;

}


