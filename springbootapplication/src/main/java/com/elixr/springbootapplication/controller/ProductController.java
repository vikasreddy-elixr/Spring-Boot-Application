package com.elixr.springbootapplication.controller;

import com.elixr.springbootapplication.constants.AllConstants;
import com.elixr.springbootapplication.model.Products;
import com.elixr.springbootapplication.responses.Responses;
import com.elixr.springbootapplication.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProducts(@RequestBody Products products) {
        productService.addNewProducts(products);
        return new ResponseEntity<>(new Responses(AllConstants.OPERATION_SUCCESS, products), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {

        List<Products> productsList = productService.findAllProducts();
        return new ResponseEntity<>(new Responses(AllConstants.OPERATION_SUCCESS, productsList), HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProductByProductId(@PathVariable(value = "productId") String id) {

        Products targetProduct = productService.findProductByProductId(id);
        return new ResponseEntity<>(new Responses(AllConstants.OPERATION_SUCCESS, targetProduct), HttpStatus.OK);
    }

    @PatchMapping("/products/{productId}")
    public ResponseEntity<?> patchProduct(@PathVariable("productId") String id, @RequestBody Products products) {

        Products updatedProduct = productService.updateProduct(id, products);
        return new ResponseEntity<>(new Responses(AllConstants.OPERATION_SUCCESS, updatedProduct), HttpStatus.OK);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String id, @RequestBody Products products) {

        Products deleteProduct = productService.deleteProductByProductId(id,products);
        return new ResponseEntity<>(new Responses(AllConstants.OPERATION_SUCCESS, deleteProduct), HttpStatus.OK);

    }
}
