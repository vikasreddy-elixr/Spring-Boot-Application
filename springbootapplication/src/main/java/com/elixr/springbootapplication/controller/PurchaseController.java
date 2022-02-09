package com.elixr.springbootapplication.controller;

import com.elixr.springbootapplication.model.Purchase;
import com.elixr.springbootapplication.services.PurchaseServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PurchaseController {

    PurchaseServices services;

    public PurchaseController(PurchaseServices purchaseServices) {
        this.services = purchaseServices;
    }

    @PostMapping("purchases")
    public ResponseEntity<?> createPurchase(@Valid @RequestBody Purchase purchase) {
        return services.postPurchase(purchase);
    }

    @GetMapping("purchases")
    public ResponseEntity<?> getPurchases() {
        return services.getPurchases();
    }

    @GetMapping("purchases/{purchaseId}")
    public ResponseEntity<?> getPurchaseById(@PathVariable("purchaseId") String id) {
        return services.getById(id);
    }


    @DeleteMapping("purchases/{purchaseId}")
    public ResponseEntity<?> deletePurchase(@PathVariable String purchaseId) {
        return services.deletePurchase(purchaseId);
    }

    @PatchMapping("purchases/{id}")
    public ResponseEntity<?> patchPurchase(@PathVariable String id, @Valid @RequestBody Purchase purchases) {
        return ResponseEntity.ok(services.patchPurchase(id, purchases));
    }


}
