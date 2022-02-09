package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.exception.NotFoundException;
import com.elixr.springbootapplication.model.Purchases;
import com.elixr.springbootapplication.repository.PurchaseRepository;
import com.elixr.springbootapplication.response.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PurchaseService {
    PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public ResponseEntity<?> postPurchase(Purchases purchase) {
        Purchases postPurchases = purchaseRepository.save(purchase);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, postPurchases), HttpStatus.OK);
    }

    public ResponseEntity<?> getPurchases() {
        List<Purchases> getPurchases = purchaseRepository.findAll();
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, getPurchases), HttpStatus.OK);
    }

    public ResponseEntity<?> getById(String purchaseId) {
        Optional<Purchases> getPurchasesById = purchaseRepository.findById(purchaseId);
        getPurchasesById.orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, getPurchasesById), HttpStatus.OK);
    }

    public ResponseEntity<?> deletePurchase(String purchaseId) {
        Optional<Purchases> deletePurchase = purchaseRepository.findById(purchaseId);
        deletePurchase.orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        purchaseRepository.deleteById(purchaseId);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, deletePurchase), HttpStatus.OK);
    }

    public ResponseEntity<?> patchPurchase(String id, Purchases purchase) {
        Purchases patchPurchases = purchaseRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        patchPurchases.setUserName(purchase.getUserName());
        patchPurchases.setProductName(purchase.getProductName());
        patchPurchases.setAmount(purchase.getAmount());
        purchaseRepository.save(purchase);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, purchase), HttpStatus.OK);
    }

}
