package com.vangguard.myshopee.service;

import com.vangguard.myshopee.models.Product;
import com.vangguard.myshopee.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl  implements ProductService{
    private  final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    System.out.println(productRepository);
    }


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
