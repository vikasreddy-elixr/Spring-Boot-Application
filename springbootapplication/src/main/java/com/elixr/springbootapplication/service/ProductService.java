package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.model.Products;

import java.util.List;

public interface ProductService {

    void addNewProducts(Products products);

    List<Products> findAllProducts();

    Products findProductByProductId(String id);

    Products updateProduct(String id, Products products);

    Products deleteProductByProductId(String id, Products products);
}
