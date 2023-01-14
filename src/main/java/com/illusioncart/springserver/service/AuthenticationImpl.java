package com.illusioncart.springserver.service;

import com.illusioncart.springserver.config.JwtService;
import com.illusioncart.springserver.model.User;
import com.illusioncart.springserver.model.requset.LoginReq;
import com.illusioncart.springserver.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationImpl implements AuthenticationService {
    @Autowired
    private UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public String register(User user) throws Exception {

        Optional<User> emailExist = userDao.findByEmail(user.getEmail());
        if (emailExist.isPresent()) {
            throw new Exception("Email already exist");
        }

        User entryUser = User.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .build();
        userDao.save(entryUser);
        return jwtService.generateToken(user);
    }

    @Override
    public String login(LoginReq user) throws Exception {

        User jwtUser = userDao.findByEmail(
                user.getEmail()
        ).orElseThrow(() -> new Exception("Email doesn't exist"));

        boolean isMatch = passwordEncoder.matches(user.getPassword(), jwtUser.getPassword());

        if (!isMatch) throw new Exception("Incorrect password");

        /*
          authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                 user.getEmail(),
                 user.getPassword()
         ));
        */

        return jwtService.generateToken(jwtUser);
    }


}

