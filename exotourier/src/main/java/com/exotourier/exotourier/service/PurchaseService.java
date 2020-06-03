package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.PurchaseDao;
import com.exotourier.exotourier.domain.Purchase;
import com.exotourier.exotourier.exception.PurchaseNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseDao purchaseDao;

    @Autowired
    public PurchaseService(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
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

}
