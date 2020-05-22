package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.Purchase;
import com.exotourier.exotourier.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pruchases")
public class PurchaseController {
    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/")
    public List<Purchase> getAll(){
        return purchaseService.getAll();
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
