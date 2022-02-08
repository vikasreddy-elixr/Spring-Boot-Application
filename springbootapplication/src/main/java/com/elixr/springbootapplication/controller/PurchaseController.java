package com.elixr.springbootapplication.controller;

import com.elixr.springbootapplication.model.Purchase;
import com.elixr.springbootapplication.services.Services;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PurchaseController {

    Services services;

    public PurchaseController(Services services) {
        this.services = services;
    }

    @PostMapping("purchases")
    public ResponseEntity<?> postPurchases(@Valid @RequestBody Purchase purchase) {
        return services.postPurchases(purchase);
    }

    @GetMapping("purchases")
    public ResponseEntity<?> getPurchase() {
        return services.getPurchases();
    }

    @GetMapping("purchases/{purchaseId}")
    public ResponseEntity<?> getById(@PathVariable("purchaseId") String id) {
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
