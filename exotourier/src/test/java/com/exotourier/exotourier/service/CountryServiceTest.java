package com.exotourier.exotourier.service;

import com.exotourier.exotourier.TestFixture;
import com.exotourier.exotourier.dao.CountryDao;
import com.exotourier.exotourier.domain.Country;
import com.exotourier.exotourier.exception.country.CountryAlreadyExistException;
import com.exotourier.exotourier.exception.country.CountryNotExistException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class CountryServiceTest {
    CountryService countryService;

    @Mock
    CountryDao countryDao;

    @Before
    public void setUp() {
        initMocks(this);
        this.countryService = new CountryService(countryDao);
    }

    @Test
    public void testCreateOk() throws CountryAlreadyExistException {

        Country newCountry = TestFixture.testCountry();

        when(countryDao.findByName(newCountry.getName())).thenReturn(Optional.empty());
        when(countryDao.save(newCountry)).thenReturn(newCountry);

        Country returnedProvince = this.countryService.create(newCountry);
        System.out.println(returnedProvince);

        assertEquals(newCountry.getId(), returnedProvince.getId());
        assertEquals(newCountry.getName(), returnedProvince.getName());
    }


    @Test(expected = CountryAlreadyExistException.class)
    public void testCreateExistingCountry() throws CountryAlreadyExistException {

        Country newCountry = TestFixture.testCountry();

        when(countryDao.findByName(newCountry.getName())).thenReturn(Optional.ofNullable(newCountry));
        countryService.create(newCountry);
    }


    @Test
    public void testGetAllOk() {
        List<Country> allCountries = TestFixture.testListOfCountries();
        when(countryDao.findAll()).thenReturn(allCountries);

        List<Country> returnedCountries = countryService.getAll();

        assertEquals(returnedCountries.size(), allCountries.size());
        assertEquals(returnedCountries.get(0).getId(), allCountries.get(0).getId());
    }

    @Test
    public void testGetByIdOk() throws CountryNotExistException {

        Country newCountry = TestFixture.testCountry();

        when(countryDao.findById(1)).thenReturn(Optional.ofNullable(newCountry));

        Country returnedProvince = this.countryService.getById(1);

        assertEquals(newCountry.getId(), returnedProvince.getId());
    }



    @Test(expected = CountryNotExistException.class)
    public void testGetByIdCountryDoesNotExist() throws CountryNotExistException {

        Country newCountry = TestFixture.testCountry();

        when(countryDao.findById(1)).thenReturn(Optional.empty());
        countryService.getById(1);
    }

}
