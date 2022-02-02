package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.model.Products;

import java.util.List;

public interface ProductService {

    void addNewProducts(Products products);

    List<Products> findAllProducts();

    Products findProductByProductId(String productId);

    //Products findProductByProductNameFromPurchases(productName, purchases);

    Products updateProduct(String productId, Products products);

    void deleteProductByProductId(String productId);
}
