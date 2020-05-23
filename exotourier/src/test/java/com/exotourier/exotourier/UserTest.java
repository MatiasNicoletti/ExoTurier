package com.exotourier.exotourier;


import com.exotourier.exotourier.dao.UserDao;
import com.exotourier.exotourier.domain.User;
import com.exotourier.exotourier.exception.UserNotFoundException;
import com.exotourier.exotourier.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class UserTest {

    @Mock
    UserDao userDao;

    @Mock
    UserService userService;

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    public void testGetById() throws UserNotFoundException {

       // User userLogged = new User(1, "name", "surname", "ryan@gmail.com", "123456", true);
       // when(userService.getById(1)).thenReturn(userLogged);

        //User userTest = this.userDao.findById(1).get();
      //  User userTest = userService.getById(1);

      //  Assert.assertEquals(userLogged.getEmail(), userTest.getEmail());
    }
}
