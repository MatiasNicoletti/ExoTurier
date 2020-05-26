package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.Purchase;
import com.exotourier.exotourier.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Purchase>> getAll(){
        List<Purchase> purchases = purchaseService.getAll();
        return (purchases.size() > 0) ? ResponseEntity.ok(purchases) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/")
    public Purchase create(Purchase purchase){
        return purchaseService.create(purchase);
    }

    @GetMapping("/{idCountry}")
    public Purchase getById(@PathVariable Integer idPurchase){
        return purchaseService.getById(idPurchase).get();
    }
}
