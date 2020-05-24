package com.exotourier.exotourier.dao;

import com.exotourier.exotourier.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);

}
