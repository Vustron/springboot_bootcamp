package com.vustron.springauth.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vustron.springauth.models.Users;
import com.vustron.springauth.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  @Autowired
  AuthenticationManager authManager;

  @Autowired
  private JWTService jwtService;

  private BCryptPasswordEncoder brcrypt = new BCryptPasswordEncoder(12);

  public Users register(Users user) {
    user.setPassword(brcrypt.encode(user.getPassword()));
    return repository.save(user);
  }

  public String verify(Users user) {
    Authentication authentication = authManager
        .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

    if (authentication.isAuthenticated()) {
      return jwtService.generateToken(user.getUsername());
    }

    return "Fail";
  }

}
