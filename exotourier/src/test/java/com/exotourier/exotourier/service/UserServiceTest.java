package com.exotourier.exotourier.service;

import com.exotourier.exotourier.TestFixture;
import com.exotourier.exotourier.dao.UserDao;
import com.exotourier.exotourier.domain.User;
import com.exotourier.exotourier.exception.user.UserEmailAlreadyExistException;
import com.exotourier.exotourier.exception.user.UserNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class UserServiceTest {
    UserService userService;

    @Mock
    UserDao userDao;

    @Before
    public void setUp() {
        initMocks(this);
        this.userService = new UserService(userDao);
    }

    @Test
    public void testCreateOk() throws UserEmailAlreadyExistException {

        User newUser = TestFixture.testUser();

        when(userDao.findByEmail(newUser.getEmail())).thenReturn(Optional.empty());
        when(userDao.save(newUser)).thenReturn(newUser);

        User returnedUser = this.userService.create(newUser);

        assertEquals(newUser.getId(), returnedUser.getId());
        assertEquals(newUser.getEmail(), returnedUser.getEmail());
    }


    @Test(expected = UserEmailAlreadyExistException.class)
    public void testCreateExistingCountry() throws UserEmailAlreadyExistException {

        User newUser = TestFixture.testUser();

        when(userDao.findByEmail(newUser.getEmail())).thenReturn(Optional.ofNullable(newUser));
        userService.create(newUser);
    }


    @Test
    public void testGetAllOk() {
        List<User> allUsers = TestFixture.testListOfUsers();
        when(userDao.findAll()).thenReturn(allUsers);

        List<User> returnedCountries = userService.getAll();

        assertEquals(returnedCountries.size(), allUsers.size());
        assertEquals(returnedCountries.get(0).getId(), allUsers.get(0).getId());
    }

    @Test
    public void testGetByIdOk() throws UserNotFoundException {

        User newUser = TestFixture.testUser();

        when(userDao.findById(1)).thenReturn(Optional.ofNullable(newUser));

        User returnedUser = this.userService.getById(1);

        assertEquals(newUser.getId(), returnedUser.getId());
    }



    @Test(expected = UserNotFoundException.class)
    public void testGetByIdCountryDoesNotExist() throws UserNotFoundException {

        User newUser = TestFixture.testUser();

        when(userDao.findById(1)).thenReturn(Optional.empty());
        userService.getById(1);
    }

}
