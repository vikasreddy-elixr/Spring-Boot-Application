package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.exception.NotFoundException;
import com.elixr.springbootapplication.model.Purchase;
import com.elixr.springbootapplication.model.User;
import com.elixr.springbootapplication.repository.PurchaseRepository;
import com.elixr.springbootapplication.repository.UserRepository;
import com.elixr.springbootapplication.responses.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private final UserRepository userRepository;
    private final PurchaseRepository purchaseRepository;

    public PurchaseService(UserRepository userRepository, PurchaseRepository purchaseRepository) {
        this.userRepository = userRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public ResponseEntity<?> postPurchase(@Valid Purchase purchase) {
        Purchase postPurchase = purchaseRepository.save(purchase);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, postPurchase), HttpStatus.OK);
    }

    public ResponseEntity<?> getPurchases() {
        List<Purchase> getPurchases = purchaseRepository.findAll();
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, getPurchases), HttpStatus.OK);
    }

    public ResponseEntity<?> getPurchaseById(String purchaseId) {
        Optional<Purchase> getPurchaseById = purchaseRepository.findById(purchaseId);
        getPurchaseById.orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, getPurchaseById), HttpStatus.OK);
    }

    public ResponseEntity<?> getPurchasesByProductName(Optional<String> productName) {
        List<Purchase> targetPurchaseList = purchaseRepository.findPurchasesByProductName(productName);
        if (!targetPurchaseList.isEmpty()) {
            return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, targetPurchaseList), HttpStatus.OK);
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
        Purchase patchPurchase = purchaseRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        patchPurchase.setUserName(purchase.getUserName());
        patchPurchase.setProductName(purchase.getProductName());
        patchPurchase.setAmount(purchase.getAmount());
        purchaseRepository.save(purchase);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, purchase), HttpStatus.OK);
    }

    public ResponseEntity<?> getPurchasesByUserId(String userId) {
        User userById = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        String userName = userById.getUserName();
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, purchaseRepository.getPurchasesByUserName(userName)), HttpStatus.OK);
    }

    public ResponseEntity<?> getPurchasesByUserName(String userName) {
        List<Purchase> purchaseList = purchaseRepository.findPurchasesByUserName(userName);
        if (!purchaseList.isEmpty()) {
            return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, purchaseList), HttpStatus.OK);
        } else {
            throw new NotFoundException(Constants.ERROR_NOT_FOUND);
        }
    }
}

