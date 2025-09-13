package com.vustron.springauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vustron.springauth.models.Users;
import com.vustron.springauth.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  private BCryptPasswordEncoder brcrypt = new BCryptPasswordEncoder(12);

  public Users register(Users user) {
    user.setPassword(brcrypt.encode(user.getPassword()));
    return repository.save(user);
  }

}
