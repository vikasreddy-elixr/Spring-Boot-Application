package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.model.Product;
import com.elixr.springbootapplication.model.Purchase;

import java.util.List;

public interface ProductService {

    void addNewProduct(Product product);

    List<Product> findAllProducts();

    Product findProductByProductId(String id);

    List<Purchase> findPurchasesByProductName(String productName);

    Product updateProduct(String id, Product product);

    String deleteProductByProductId(String id);
}
