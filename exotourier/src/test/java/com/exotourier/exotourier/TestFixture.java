package com.exotourier.exotourier;

import com.exotourier.exotourier.domain.City;
import com.exotourier.exotourier.domain.Country;

import java.util.ArrayList;
import java.util.List;

public class TestFixture {

    public static List<Country> testListOfCountries() {
        List<Country> countries = new ArrayList<>();
        Country newCountry = Country.builder()
                .id(1)
                .name("Argentina")
                .build();

        Country newCountry2 = Country.builder()
                .id(1)
                .name("Argentina")
                .build();

        countries.add(newCountry);
        countries.add(newCountry2);

        return countries;
    }

    public static Country testCountry() {
        Country newCountry = Country.builder()
                .id(1)
                .name("Argentina")
                .build();
        return newCountry;
    }

    public static List<City> testListOfCities() {
        List<City> cities = new ArrayList<>();
        City testCity = City.builder()
                .id(1)
                .name("Argentina")
                .build();

        City testCity2 = City.builder()
                .id(1)
                .name("Argentina")
                .build();

        cities.add(testCity);
        cities.add(testCity2);

        return cities;
    }

    public static City testCity() {
        City newCity = City.builder()
                .id(1)
                .name("Argentina")
                .country(testCountry())
                .excursions(new ArrayList<>())
                .build();
        return newCity;
    }
    }
