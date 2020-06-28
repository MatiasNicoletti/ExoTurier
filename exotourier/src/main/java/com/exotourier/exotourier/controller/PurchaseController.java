package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.Excursion;
import com.exotourier.exotourier.domain.Purchase;
import com.exotourier.exotourier.exception.excursion.ExcursionNotExistException;
import com.exotourier.exotourier.exception.PurchaseNotExistException;
import com.exotourier.exotourier.projection.MostPurchased;
import com.exotourier.exotourier.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final ExcursionController excursionController;

    @Autowired
    public PurchaseController(PurchaseService purchaseService, ExcursionController excursionController) {
        this.purchaseService = purchaseService;
        this.excursionController = excursionController;
    }

    @GetMapping("/")
    public ResponseEntity<List<Purchase>> getAll(){
        List<Purchase> purchases = purchaseService.getAll();
        return (purchases.size() > 0) ? ResponseEntity.ok(purchases) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/")
    public ResponseEntity create(@RequestBody @Valid Purchase purchase){
        Purchase newPurchase = purchaseService.create(purchase);
        return ResponseEntity.created(getLocation(newPurchase)).build();
    }

    @GetMapping("/{idPurchase}")
    public ResponseEntity<Purchase> getById(@PathVariable Integer idPurchase) throws PurchaseNotExistException {
        Purchase purchase = purchaseService.getById(idPurchase);
        return ResponseEntity.ok(purchase);
    }

    @GetMapping("/mostPurchased")
    public ResponseEntity<ResponseEntity<Excursion>> getMostPurchased() throws ExcursionNotExistException {
        MostPurchased mostPurchased= purchaseService.getMostPurchased();
        Integer id = mostPurchased.getId_excursion();
        ResponseEntity<Excursion> exc = excursionController.getById(id);
        return ResponseEntity.ok(exc);
    }

    private URI getLocation(Purchase purchase) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(purchase.getId())
                .toUri();
    }
}
