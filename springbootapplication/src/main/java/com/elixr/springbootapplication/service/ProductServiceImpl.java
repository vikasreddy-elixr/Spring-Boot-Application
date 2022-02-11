package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.exception.NotFoundException;
import com.elixr.springbootapplication.model.Product;
import com.elixr.springbootapplication.model.Purchase;
import com.elixr.springbootapplication.repository.ProductRepository;
import com.elixr.springbootapplication.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;

    @Override
    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductByProductId(String id) {

        return productRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
    }

    public List<Purchase> findPurchasesByProductName(String productName) {
        List<Purchase> targetPurchase = purchaseRepository.findPurchasesByProductName(productName);
        if (!targetPurchase.isEmpty()) {
            return targetPurchase;
        } else {
            throw new NotFoundException(Constants.ERROR_NOT_FOUND);
        }
    }

    @Override
    public Product updateProduct(String id, Product product) {

        Product targetProduct = productRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        targetProduct.setProductName(product.getProductName());
        targetProduct.setQuantity(product.getQuantity());
        targetProduct.setPrice(product.getPrice());
        return productRepository.save(product);
    }

    @Override
    public String deleteProductByProductId(String id) {
        Boolean doesTargetProductExist = productRepository.existsById(id);
        if (doesTargetProductExist) {
            productRepository.deleteById(id);
            return Constants.PROMPT_PRODUCT_SUCCESSFUL_DELETION;
        } else {
            throw new NotFoundException(Constants.ERROR_NOT_FOUND);
        }
    }
}
