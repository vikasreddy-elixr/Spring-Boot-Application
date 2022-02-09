package com.elixr.springbootapplication.controller;

import com.elixr.springbootapplication.model.Purchases;
import com.elixr.springbootapplication.service.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;

import javax.validation.Valid;


@RestController
public class PurchaseController {
    final PurchaseService services;

    public PurchaseController(PurchaseService services) {
        this.services = services;
    }

    @PostMapping("purchases")
    public ResponseEntity<?> createPurchase(@Valid @RequestBody Purchases purchases) {
        return services.postPurchase(purchases);
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
    public ResponseEntity<?> patchPurchase(@PathVariable String id, @Valid Purchases purchases) {
        return ResponseEntity.ok(services.patchPurchase(id, purchases));
    }
}
