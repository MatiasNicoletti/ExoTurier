package com.exotourier.exotourier.service;

import com.exotourier.exotourier.TestFixture;
import com.exotourier.exotourier.dao.UserExcursionDao;
import com.exotourier.exotourier.domain.UserExcursion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class UserExcursionServiceTest {
    UserExcursionService userExcursionService;

    @Mock
    UserExcursionDao userExcursionDao;

    @Before
    public void setUp() {
        initMocks(this);
        this.userExcursionService = new UserExcursionService(userExcursionDao);
    }

    @Test
    public void testCreateOk(){

        UserExcursion newUser = TestFixture.testUserExcursion();
        when(userExcursionDao.save(newUser)).thenReturn(newUser);

        UserExcursion returnedUser = this.userExcursionService.create(newUser);

        assertEquals(newUser.getId(), returnedUser.getId());
        assertEquals(newUser.getRating(), returnedUser.getRating());
    }


    @Test
    public void testGetAllOk() {
        List<UserExcursion> allUsers = TestFixture.testListOfUsersExcursions();
        when(userExcursionDao.findAll()).thenReturn(allUsers);

        List<UserExcursion> returnedCountries = userExcursionService.getAll();

        assertEquals(returnedCountries.size(), allUsers.size());
        assertEquals(returnedCountries.get(0).getId(), allUsers.get(0).getId());
    }

    @Test
    public void testGetByIdOk() {

        UserExcursion newUser = TestFixture.testUserExcursion();

        when(userExcursionDao.findById(1)).thenReturn(Optional.ofNullable(newUser));

        Optional<UserExcursion> returnedUser = this.userExcursionService.getById(1);

        assertEquals(newUser.getId(), returnedUser.get().getId());
    }
    
}
