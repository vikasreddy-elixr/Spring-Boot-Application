package com.elixr.springbootapplication.purchasecontroller;


import com.elixr.springbootapplication.service.PurchaseService;
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
    public ResponseEntity<?> createPurchase(@Valid  @RequestBody com.elixr.springbootapplication.model.Purchase purchases) {
        return services.postPurchase(purchases);
    }

    @GetMapping("purchases")
    public ResponseEntity<?> getPurchase() {
        return services.getPurchases();
    }

    @GetMapping("purchases/{purchaseId}")
    public ResponseEntity<?> getByPurchaseId(@PathVariable("purchaseId") String id) {
        return services.getById(id);
    }

    @DeleteMapping("purchases/{purchaseId}")
    public ResponseEntity<?> deleteUser(@PathVariable String purchaseId) {
        return services.deletePurchase(purchaseId);
    }

    @PatchMapping("purchases/{id}")
    public ResponseEntity<?> patchPurchase(@PathVariable String id,@Valid com.elixr.springbootapplication.model.Purchase purchases) {
        return ResponseEntity.ok(services.patchPurchase(id, purchases));
    }
}
