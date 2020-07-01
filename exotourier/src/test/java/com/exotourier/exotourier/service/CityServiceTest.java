package com.exotourier.exotourier.service;

import com.exotourier.exotourier.TestFixture;
import com.exotourier.exotourier.dao.CityDao;
import com.exotourier.exotourier.domain.City;
import com.exotourier.exotourier.exception.city.CityAlreadyExistException;
import com.exotourier.exotourier.exception.city.CityNotExistException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class CityServiceTest {
    CityService cityService;

    @Mock
    CityDao cityDao;

    @Before
    public void setUp() {
        initMocks(this);
        this.cityService = new CityService(cityDao);
    }

    @Test
    public void testCreateOk() throws CityAlreadyExistException {

        City newCity = TestFixture.testCity();

        when(cityDao.findByName(newCity.getName())).thenReturn(Optional.empty());
        when(cityDao.save(newCity)).thenReturn(newCity);

        City returnedCity = this.cityService.create(newCity);
        System.out.println(returnedCity);

        assertEquals(newCity.getId(), returnedCity.getId());
        assertEquals(newCity.getName(), returnedCity.getName());
    }


    @Test(expected = CityAlreadyExistException.class)
    public void testCreateExistingCity() throws CityAlreadyExistException {

        City newCity = TestFixture.testCity();

        when(cityDao.findByName(newCity.getName())).thenReturn(Optional.ofNullable(newCity));
        cityService.create(newCity);
    }


    @Test
    public void testGetAllOk() {
        List<City> allCities = TestFixture.testListOfCities();
        when(cityDao.findAll()).thenReturn(allCities);

        List<City> returnedCities = cityService.getAll();

        assertEquals(returnedCities.size(), allCities.size());
        assertEquals(returnedCities.get(0).getId(), allCities.get(0).getId());
    }

    @Test
    public void testGetByIdOk() throws CityNotExistException {

        City newCity = TestFixture.testCity();

        when(cityDao.findById(1)).thenReturn(Optional.ofNullable(newCity));

        City returnedCity = this.cityService.getById(1);

        assertEquals(newCity.getId(), returnedCity.getId());
    }



    @Test(expected = CityNotExistException.class)
    public void testGetByIdCityDoesNotExist() throws CityNotExistException {

        City newCity = TestFixture.testCity();

        when(cityDao.findById(1)).thenReturn(Optional.empty());
        cityService.getById(1);
    }



}
