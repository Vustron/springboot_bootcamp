package com.vustron.springauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vustron.springauth.models.Users;
import com.vustron.springauth.services.UserService;

@RestController
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping("/register")
  public Users register(@RequestBody Users user) {
    return service.register(user);
  }

  @PostMapping("/sign-in")
  public String login(@RequestBody Users user) {
    return service.verify(user);
  }

}
