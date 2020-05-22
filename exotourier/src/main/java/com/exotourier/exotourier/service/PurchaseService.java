package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.PurchaseDao;
import com.exotourier.exotourier.domain.Purchase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PurchaseService {
    private PurchaseDao purchaseDao;

    @Autowired
    public PurchaseService(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }

    public List<Purchase> getAll(){
        return this.purchaseDao.findAll();
    }
    public Purchase create(Purchase purchase){
        return this.purchaseDao.save(purchase);
    }

    public Optional<Purchase> getById(Integer id){
        return purchaseDao.findById(id);
    }
}
