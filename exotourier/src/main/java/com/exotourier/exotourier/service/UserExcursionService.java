package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.UserExcursionDao;
import com.exotourier.exotourier.domain.UserExcursion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserExcursionService {

    private UserExcursionDao userExcursionDao;

    @Autowired
    public UserExcursionService(UserExcursionDao userExcursionDao) {
        this.userExcursionDao = userExcursionDao;
    }

    public List<UserExcursion> getAll(){
        return this.userExcursionDao.findAll();
    }

    public UserExcursion create(UserExcursion userExcursion){
        return this.userExcursionDao.save(userExcursion);
    }

    public Optional<UserExcursion> getById(Integer id){
        return userExcursionDao.findById(id);
    }
}
