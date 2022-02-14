package com.elixr.springbootapplication.controller;


import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.model.Purchase;
import com.elixr.springbootapplication.responses.SuccessResponse;
import com.elixr.springbootapplication.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


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
    public ResponseEntity<?> getPurchases(@RequestParam(value = "productName") Optional<String> productName) {
        if(productName.isEmpty()) {
            return purchaseService.getPurchases();
        } else {
            List<Purchase> targetProducts = purchaseService.findPurchasesByProductName(productName);
            return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, targetProducts), HttpStatus.OK);
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
    public ResponseEntity<?> patchPurchase(@PathVariable String purchaseId, @Valid Purchase purchases) {
        return ResponseEntity.ok(purchaseService.patchPurchase(purchaseId, purchases));
    }
}
