package com.elixr.springbootapplication.services;

import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.exceptionhandler.NotFoundException;
import com.elixr.springbootapplication.repository.PurchaseRepository;
import com.elixr.springbootapplication.model.Purchase;
import com.elixr.springbootapplication.response.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Services {
    PurchaseRepository purchaseRepository;

    public Services(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public ResponseEntity<?> postPurchases(Purchase purchases) {
        Purchase postPurchases = purchaseRepository.save(purchases);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, postPurchases), HttpStatus.OK);
    }

    public ResponseEntity<?> getPurchases() {
        List<Purchase> getPurchases = purchaseRepository.findAll();
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, getPurchases), HttpStatus.OK);
    }

    public ResponseEntity<?> getById(String purchaseId) {
        Purchase getPurchasesById = purchaseRepository.findById(purchaseId).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, getPurchasesById), HttpStatus.OK);
    }

    public ResponseEntity<?> deletePurchase(String purchaseId) {
        Purchase deletePurchase = purchaseRepository.findById(purchaseId).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        purchaseRepository.deleteById(purchaseId);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, deletePurchase), HttpStatus.OK);
    }

    public ResponseEntity<?> patchPurchase(String id, Purchase purchase) {
        Purchase patchPurchases = purchaseRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        patchPurchases.setUserName(purchase.getUserName());
        patchPurchases.setProductName(purchase.getProductName());
        patchPurchases.setAmount(purchase.getAmount());
        purchaseRepository.save(purchase);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, purchase), HttpStatus.OK);
    }
}
