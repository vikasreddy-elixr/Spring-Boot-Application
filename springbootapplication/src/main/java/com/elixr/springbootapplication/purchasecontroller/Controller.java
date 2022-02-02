package com.elixr.springbootapplication.purchasecontroller;

import com.elixr.springbootapplication.model.Purchases;
import com.elixr.springbootapplication.services.Services;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
public class Controller {
    private final Services services;

    public Controller(Services services) {
        this.services = services;
    }

    @PostMapping("purchases")
    public ResponseEntity<?> postPurchase(@Valid  @RequestBody Purchases purchases) {
        return services.postPurchases(purchases);
    }

    @GetMapping("purchases")
    public ResponseEntity<?> getPurchase() {
        return services.getPurchase();
    }

    @GetMapping("purchases/{purchaseId}")
    public ResponseEntity<?> getById(@PathVariable("purchaseId") String id) {
        return services.getById(id);
    }

    @DeleteMapping("purchases/{purchaseId}")
    public ResponseEntity<?> deleteUser(@PathVariable String purchaseId) {
        return services.deleteUser(purchaseId);
    }

    @PatchMapping("purchases/{id}")
    public ResponseEntity<?> patchPurchase(@PathVariable String id,@Valid Purchases purchases) {
        return ResponseEntity.ok(services.patchPurchase(id, purchases));
    }
}
