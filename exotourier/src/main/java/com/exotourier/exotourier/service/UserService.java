package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.UserDao;
import com.exotourier.exotourier.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll(){
        return this.userDao.findAll();
    }

    public User create(User user){
        return this.userDao.save(user);
    }

    public Optional<User> getById(Integer id){
        return this.userDao.findById(id);
    }
}
