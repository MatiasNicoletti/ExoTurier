package com.exotourier.exotourier.dao;

import com.exotourier.exotourier.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);


    @Query(
            value = "SELECT count(u.id) " +
                    "FROM users u " +
                    "WHERE u.username = ?1" +
                    "AND u.password = ?2",
            nativeQuery = true
    )
    int findByUsernameBoolean(String username);

    @Query(
            value = "SELECT *" +
                    "FROM users"+
                    "WHERE u.email = ?1 AND"+
                    "u.password = ?2"
    )
    User findByUsernameAndPassword(String email, String password);
}
