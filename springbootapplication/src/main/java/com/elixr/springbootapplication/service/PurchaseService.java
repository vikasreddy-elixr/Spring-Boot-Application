package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.exception.NotFoundException;
import com.elixr.springbootapplication.model.Purchase;
import com.elixr.springbootapplication.repository.PurchaseRepository;
import com.elixr.springbootapplication.responses.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Service
public class PurchaseService {
    PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public ResponseEntity<?> postPurchase(@Valid Purchase purchase) {
        Purchase postPurchases = purchaseRepository.save(purchase);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, postPurchases), HttpStatus.OK);
    }

    public ResponseEntity<?> getPurchases() {
        List<Purchase> getPurchases = purchaseRepository.findAll();
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, getPurchases), HttpStatus.OK);
    }

    public ResponseEntity<?> getPurchaseById(String purchaseId) {
        Optional<Purchase> getPurchasesById = purchaseRepository.findById(purchaseId);
        getPurchasesById.orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, getPurchasesById), HttpStatus.OK);
    }

    public ResponseEntity<?> getByProductName(Optional<String> productName) {
        List<Purchase> targetPurchase = purchaseRepository.findPurchasesByProductName(productName);
        if (!targetPurchase.isEmpty()) {
            return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, targetPurchase), HttpStatus.OK);
        } else {
            throw new NotFoundException(Constants.ERROR_NOT_FOUND);
        }
    }

    public String deletePurchaseById(String purchaseId) {
        boolean doesTargetProductExist = purchaseRepository.existsById(purchaseId);
        if (doesTargetProductExist) {
            purchaseRepository.deleteById(purchaseId);
            return Constants.PROMPT_PRODUCT_SUCCESSFUL_DELETION;
        } else {
            throw new NotFoundException(Constants.ERROR_NOT_FOUND);
        }
    }

    public ResponseEntity<?> patchPurchase(String id, @Valid Purchase purchase) {
        Purchase patchPurchases = purchaseRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        patchPurchases.setUserName(purchase.getUserName());
        patchPurchases.setProductName(purchase.getProductName());
        patchPurchases.setAmount(purchase.getAmount());
        purchaseRepository.save(purchase);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, purchase), HttpStatus.OK);
    }

}
