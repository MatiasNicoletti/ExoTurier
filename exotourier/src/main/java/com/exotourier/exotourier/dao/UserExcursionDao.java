package com.exotourier.exotourier.dao;

import com.exotourier.exotourier.domain.UserExcursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExcursionDao extends JpaRepository<UserExcursion,Integer> {

}

