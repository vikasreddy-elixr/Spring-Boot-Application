package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.exception.NotFoundException;
import com.elixr.springbootapplication.model.Product;
import com.elixr.springbootapplication.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

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

    @Override
    public Product updateProduct(String id, Product product) {

        Product targetProduct = productRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        targetProduct.setProductName(product.getProductName());
        targetProduct.setQuantity(product.getQuantity());
        targetProduct.setPrice(product.getPrice());
        return productRepository.save(product);
    }

    @Override
    public Product deleteProductByProductId(String id) {
        Product targetProduct = productRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        productRepository.deleteById(id);
        return targetProduct;
    }
}
