package com.exotourier.exotourier;

import com.exotourier.exotourier.domain.*;

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


    public static List<User> testListOfUsers() {
        List<User> users = new ArrayList<>();
        User newUser1= User.builder()
                .id(1)
                .firstname("juan")
                .surname("del Monte")
                .email("juancito@gmail.com")
                .password("1234")
                .isActive(true)
                .purchases(new ArrayList<>())
                .userExcursionList(new ArrayList<>())
                .build();

        User newUser2 = User.builder()
                .id(1)
                .firstname("Cuchi")
                .surname("Leguizamon")
                .email("cuchi@gmail.com")
                .password("1234")
                .isActive(true)
                .purchases(new ArrayList<>())
                .userExcursionList(new ArrayList<>())
                .build();

        users.add(newUser1);
        users.add(newUser2);

        return users;
    }

    public static User testUser() {
        User newUser = User.builder()
                .id(1)
                .firstname("juan")
                .surname("del Monte")
                .email("juancito@gmail.com")
                .password("1234")
                .isActive(true)
                .purchases(new ArrayList<>())
                .userExcursionList(new ArrayList<>())
                .build();
        return newUser;
    }

    public static List<UserExcursion> testListOfUsersExcursions() {
        List<UserExcursion> userExcursions = new ArrayList<>();
        UserExcursion userExcursion= UserExcursion.builder()
                .id(1)
                .user(testUser())
                .excursion(new Excursion())
                .rating((float) 7.56)
                .build();

        UserExcursion userExcursion2 = UserExcursion.builder()
                .id(1)
                .user(testUser())
                .excursion(new Excursion())
                .rating((float) 7.56)
                .build();;

        userExcursions.add(userExcursion);
        userExcursions.add(userExcursion2);

        return userExcursions;
    }

    public static UserExcursion testUserExcursion() {
        UserExcursion newUserExcursion = UserExcursion.builder()
                .id(1)
                .user(testUser())
                .excursion(new Excursion())
                .rating((float) 7.56)
                .build();
        return newUserExcursion;
    }
}
