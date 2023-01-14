package com.illusioncart.springserver.controller;

import com.illusioncart.springserver.model.User;
import com.illusioncart.springserver.model.requset.LoginReq;
import com.illusioncart.springserver.model.response.CommonResponse;
import com.illusioncart.springserver.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<CommonResponse> register(@RequestBody User user) throws Exception {
        String accessToken = authenticationService.register(user);
        CommonResponse response = new CommonResponse();
        response.setMessage("Account created Successfully");
        response.setStatusCode(201);
        response.setAccessToken(accessToken);
        return new ResponseEntity<CommonResponse>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResponse> login(@RequestBody LoginReq req) throws Exception {
        String token = authenticationService.login(req);
        CommonResponse response = new CommonResponse();
        response.setMessage("Login Successful");
        response.setStatusCode(201);
        response.setAccessToken(token);
        return new ResponseEntity<CommonResponse>(response, HttpStatus.CREATED);
    }
}
