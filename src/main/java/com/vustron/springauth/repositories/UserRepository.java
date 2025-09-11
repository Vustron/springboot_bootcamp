package com.vustron.springauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vustron.springauth.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
  Users findByUsername(String username);
}
