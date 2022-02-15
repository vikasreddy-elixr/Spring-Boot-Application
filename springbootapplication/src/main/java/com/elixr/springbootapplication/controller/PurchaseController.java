package com.elixr.springbootapplication.controller;


import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.model.Purchase;
import com.elixr.springbootapplication.responses.SuccessResponse;
import com.elixr.springbootapplication.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import javax.validation.Valid;


@RestController
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("/purchases")
    public ResponseEntity<?> createPurchase(@Valid @RequestBody Purchase purchase) {
        return purchaseService.postPurchase(purchase);
    }

    @GetMapping("/purchases")
    public ResponseEntity<?> getPurchases(@RequestParam(value = "userName") String userName) {
        if (userName.isEmpty()) {
            return purchaseService.getPurchases();
        } else {
            return purchaseService.getPurchasesByUserName(userName);
        }
    }

    @GetMapping("/purchases/{purchaseId}")
    public ResponseEntity<?> getByPurchaseId(@PathVariable("purchaseId") String id) {
        return purchaseService.getPurchaseById(id);
    }

    @DeleteMapping("/purchases/{purchaseId}")
    public ResponseEntity<?> deletePurchaseById(@PathVariable String purchaseId) {
        String isProductDeleted = purchaseService.deletePurchaseById(purchaseId);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, isProductDeleted), HttpStatus.OK);
    }

    @PatchMapping("/purchases/{purchaseId}")
    public ResponseEntity<?> patchPurchase(@PathVariable String purchaseId, @Valid Purchase purchase) {
        return ResponseEntity.ok(purchaseService.patchPurchase(purchaseId, purchase));
    }
}
