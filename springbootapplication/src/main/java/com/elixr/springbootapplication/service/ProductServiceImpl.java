package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.exceptionhandler.ProductNotFoundException;
import com.elixr.springbootapplication.model.Products;
import com.elixr.springbootapplication.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Validated
    public void addNewProducts(Products products) {
        productRepository.save(products);
    }

    @Override
    public List<Products> findAllProducts() {
        try {
            return productRepository.findAll();
        } catch (DataAccessException e) {
            throw new ProductNotFoundException(e.getMessage());
        }
    }


    @Override
    public Products findProductByProductId(String id) {

        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

//    public FindOperation<Products> findProductByProductNameFromPurchases(String productName, Purchases purchases) {
//        return productRepository.findProductsByProductNameInPurchases(productName, purchases);
//
//    }

    @Override
    @Validated
    public Products updateProduct(String id, Products products) {

        Products targetProduct = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        targetProduct.setProductName(products.getProductName());
        targetProduct.setQuantity(products.getQuantity());
        targetProduct.setPrice(products.getPrice());
        return productRepository.save(products);
    }

    @Override
    public void deleteProductByProductId(String id) {
        productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        productRepository.deleteById(id);
    }
}
