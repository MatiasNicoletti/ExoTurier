package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.UserDao;
import com.exotourier.exotourier.domain.User;
import com.exotourier.exotourier.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserExcursionDao {
    private UserDao userDao;

    @Autowired
    public UserExcursionDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll(){
        return this.userDao.findAll();
    }

    public User create(User user){
        return this.userDao.save(user);
    }

    public User getById(Integer id) throws UserNotFoundException {
        return userDao.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
