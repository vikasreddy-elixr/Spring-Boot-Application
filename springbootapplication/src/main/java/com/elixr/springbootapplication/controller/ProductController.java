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
        return new ResponseEntity<>(new Responses(AllConstants.OPERATION_SUCCESS, AllConstants.SUCCESSFUL_PRODUCT_ADDITION, HttpStatus.OK, products), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {

        List<Products> productsList = productService.findAllProducts();
        return new ResponseEntity<>(new Responses(AllConstants.OPERATION_SUCCESS, AllConstants.SUCCESSFUL_PRODUCTS_FETCH, HttpStatus.OK, productsList), HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProductByProductId(@PathVariable("productId") String id) {

        Products targetProduct = productService.findProductByProductId(id);
        return new ResponseEntity<>(new Responses(AllConstants.OPERATION_SUCCESS, AllConstants.SUCCESSFUL_TARGET_PRODUCT_FETCH, HttpStatus.OK, targetProduct), HttpStatus.OK);
    }

//    @GetMapping("purchases?productName={productName}")
//     public ResponseEntity<Products> getProductByProductNameFromPurchases(@RequestParam(name = "productName") String productName, @RequestBody Purchases purchases) {
//         return new ResponseEntity<Products>(productService.findProductByProductNameFromPurchases(productName,purchases), HttpStatus.OK);
//     }

    @PatchMapping("/products/{productId}")
    public ResponseEntity<?> patchProduct(@PathVariable("productId") String id, @RequestBody Products products) {

        Products updatedProduct = productService.updateProduct(id, products);
        return new ResponseEntity<>(new Responses(AllConstants.OPERATION_SUCCESS, AllConstants.SUCCESSFUL_PRODUCT_UPDATE, HttpStatus.OK, updatedProduct), HttpStatus.OK);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String id) {

        productService.deleteProductByProductId(id);
        return new ResponseEntity<>(new Responses(AllConstants.OPERATION_SUCCESS, AllConstants.SUCCESSFUL_PRODUCT_DELETION, HttpStatus.OK, AllConstants.EMPTY_VALUE), HttpStatus.OK);

    }
}
