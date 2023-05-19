package com.vangguard.myshopee.resource;

import com.vangguard.myshopee.kafka.ProductProducer;
import com.vangguard.myshopee.models.Product;
import com.vangguard.myshopee.models.ProductEvent;
import com.vangguard.myshopee.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductResource {
    private  static final Logger LOGGER= LoggerFactory.getLogger(ProductProducer.class);

    private ProductService productService;
private ProductProducer productProducer;

    public ProductResource(ProductService productService, ProductProducer productProducer) {
        this.productService = productService;
        this.productProducer = productProducer;
    }

@PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
    {

       Product product1 =productService.saveProduct(product);
       ProductEvent productEvent =ProductEvent.build("pending process","pending",product);
        productProducer.produceevent(productEvent);

        return ResponseEntity.ok(product1);
    }
}
