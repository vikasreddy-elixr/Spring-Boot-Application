package com.elixr.springbootapplication.controller;

import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.model.Product;
import com.elixr.springbootapplication.responses.SuccessResponse;
import com.elixr.springbootapplication.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody @Valid Product product) {
        productService.addNewProduct(product);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, product), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {

        List<Product> productsList = productService.findAllProducts();
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, productsList), HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProductByProductId(@PathVariable(value = "productId") String id) {

        Product targetProduct = productService.findProductByProductId(id);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, targetProduct), HttpStatus.OK);
    }

    @PatchMapping("/products/{productId}")
    public ResponseEntity<?> patchProduct(@PathVariable("productId") String id, @RequestBody @Valid Product product) {

        Product updatedProduct = productService.updateProduct(id, product);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, updatedProduct), HttpStatus.OK);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String id) {

        String isProductDeleted = productService.deleteProductByProductId(id);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, isProductDeleted), HttpStatus.OK);
    }
}
