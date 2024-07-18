package com.ttk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttk.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
