package com.vangguard.myshopee.resource;

import com.vangguard.myshopee.models.Product;
import com.vangguard.myshopee.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductResource {
   private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }
@PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
    {

       Product product1 =productService.saveProduct(product);

        return ResponseEntity.ok(product1);
    }
}
