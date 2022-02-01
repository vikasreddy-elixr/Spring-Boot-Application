package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.contsants.Constants;
import com.elixr.springbootapplication.customeexceptions.CustomException;
import com.elixr.springbootapplication.repository.PurchaseRepository;
import com.elixr.springbootapplication.model.Purchases;
import com.elixr.springbootapplication.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class Services {

    private final PurchaseRepository purchaseRepository;

    public Services(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public ResponseEntity<?> postPurchases(Purchases purchases) {
        Purchases postPurchases = purchaseRepository.save(purchases);
        return new ResponseEntity<>(new Response(Constants.SUCCESS, postPurchases), HttpStatus.OK);
    }

    public ResponseEntity<?> getPurchase() {
        List<Purchases> getPurchases = purchaseRepository.findAll();
        return new ResponseEntity<>(new Response(Constants.SUCCESS, getPurchases), HttpStatus.OK);
    }

    public ResponseEntity<?> getById(String purchaseId) {
        Purchases getPurchasesById = purchaseRepository.findById(purchaseId).orElseThrow(NoSuchElementException::new);
        return new ResponseEntity<>(new Response(Constants.SUCCESS, getPurchasesById), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteUser(String purchaseId) {
        Purchases deletePurchases = purchaseRepository.findById(purchaseId).orElseThrow(CustomException::new);
        purchaseRepository.deleteById(purchaseId);
        return new ResponseEntity<>(new Response(Constants.SUCCESS, deletePurchases), HttpStatus.OK);
    }

    public ResponseEntity<?> patchPurchase(String id, Purchases purchases) {
        Purchases patchPurchases = purchaseRepository.findById(id).orElseThrow(CustomException::new);
        patchPurchases.setUserName(purchases.getUserName());
        patchPurchases.setProductName(purchases.getProductName());
        patchPurchases.setAmount(purchases.getAmount());
        purchaseRepository.save(purchases);
        return new ResponseEntity<>(new Response(Constants.SUCCESS, purchases), HttpStatus.OK);
    }

}
