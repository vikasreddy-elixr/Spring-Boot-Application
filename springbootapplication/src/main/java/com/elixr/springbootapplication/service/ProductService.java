package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.model.Product;

import java.util.List;

public interface ProductService {

    void addNewProduct(Product product);

    List<Product> findAllProducts();

    Product findProductByProductId(String id);

    Product updateProduct(String id, Product product);

    Product deleteProductByProductId(String id);
}
