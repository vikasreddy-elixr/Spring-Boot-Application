package com.elixr.springbootapplication.purchasecontroller;


import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.model.Purchase;
import com.elixr.springbootapplication.responses.SuccessResponse;
import com.elixr.springbootapplication.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;


@RestController
public class PurchaseController {
    private final PurchaseService services;

    public PurchaseController(PurchaseService services) {
        this.services = services;
    }

    @PostMapping("purchases")
    public ResponseEntity<?> createPurchase(@Valid @RequestBody Purchase purchases) {
        return services.postPurchase(purchases);
    }

    @GetMapping("purchases")
    public ResponseEntity<?> getPurchases() {
        return services.getPurchases();
    }

    @GetMapping("purchases/{purchaseId}")
    public ResponseEntity<?> getByPurchaseId(@PathVariable("purchaseId") String id) {
        return services.getPurchaseById(id);
    }

    @DeleteMapping("purchases/{purchaseId}")
    public ResponseEntity<?> deletePurchaseById(@PathVariable String purchaseId) {
        String isProductDeleted = services.deletePurchaseById(purchaseId);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, isProductDeleted), HttpStatus.OK);
    }

    @PatchMapping("purchases/{id}")
    public ResponseEntity<?> patchPurchase(@PathVariable String id, @Valid Purchase purchases) {
        return ResponseEntity.ok(services.patchPurchase(id, purchases));
    }
}
