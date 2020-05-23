package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.UserDao;
import com.exotourier.exotourier.domain.User;
import com.exotourier.exotourier.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User create(User user){
        return this.userDao.save(user);
    }

    public List<User> getAll(){
        return this.userDao.findAll();
    }

    public User getById(Integer id) throws UserNotFoundException {
        return this.userDao.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
