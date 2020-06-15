package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.UserDao;
import com.exotourier.exotourier.domain.User;
import com.exotourier.exotourier.exception.user.UserEmailAlreadyExistException;
import com.exotourier.exotourier.exception.user.UserInvalidLoginException;
import com.exotourier.exotourier.exception.user.UserNotExistException;
import com.exotourier.exotourier.exception.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User create(User user) throws UserEmailAlreadyExistException {
        Optional<User> u = userDao.findByEmail(user.getEmail());
        if (u.isPresent()) {
            throw new UserEmailAlreadyExistException();
        }
        return this.userDao.save(user);
    }

    public List<User> getAll(){
        return this.userDao.findAll();
    }

    public User getById(Integer id) throws UserNotFoundException {
        return this.userDao.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User updateById(Integer id, User updatedUser) throws UserNotExistException {
        Optional<User> user = userDao.findById(id);
        if (!user.isPresent()) {
            throw new UserNotExistException();
        }
        updatedUser.setId(id);
        return userDao.save(user.get());
    }

    public User login(String email, String password) throws UserInvalidLoginException {
            User user = userDao.findByUsernameAndPassword(email, password);
            return Optional.ofNullable(user).orElseThrow(UserInvalidLoginException::new);
    }

}
