package com.vustron.springauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vustron.springauth.models.UserPrincipal;
import com.vustron.springauth.models.Users;
import com.vustron.springauth.repositories.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {

  @Autowired
  private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users user = repository.findByUsername(username);

    if (user == null) {
      System.out.println("User not found");
      throw new UsernameNotFoundException("User not found");
    }

    return new UserPrincipal(user);
  }
}
