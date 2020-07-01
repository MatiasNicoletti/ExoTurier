package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.PurchaseDao;
import com.exotourier.exotourier.dao.UserDao;
import com.exotourier.exotourier.domain.Purchase;
import com.exotourier.exotourier.domain.User;
import com.exotourier.exotourier.exception.PurchaseNotExistException;
import com.exotourier.exotourier.exception.user.UserNotExistException;
import com.exotourier.exotourier.projection.MostPurchased;
import com.exotourier.exotourier.projection.PurchaseDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private final PurchaseDao purchaseDao;
    private final UserDao userDao;

    @Autowired
    public PurchaseService(PurchaseDao purchaseDao, UserDao userDao) {
        this.purchaseDao = purchaseDao;
        this.userDao = userDao;
    }

    public List<Purchase> getAll() {
        return this.purchaseDao.findAll();
    }
    public Purchase create(Purchase purchase) {
        return this.purchaseDao.save(purchase);
    }

    public Purchase getById(Integer id) throws PurchaseNotExistException {
        return purchaseDao.findById(id).orElseThrow(PurchaseNotExistException::new);
    }

    public MostPurchased getMostPurchased(){
        return purchaseDao.findMostPurchased();
    }

    public List<Purchase> getUserPurchases(Integer userId) throws PurchaseNotExistException, UserNotExistException {
        Optional<User> user = Optional.ofNullable(userDao.findById(userId).orElseThrow(UserNotExistException::new));
        return purchaseDao.getUserExcursions(userId).orElseThrow(PurchaseNotExistException::new);
    }

    public List<PurchaseDate> getAllBetweenDates(Date from, Date to) {
        return purchaseDao.getAllBetweenDates(from, to);
    }
}
