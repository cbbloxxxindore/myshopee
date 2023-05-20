package com.vangguard.myshopee.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
public class ProductEvent {
    private String msg;
    private String status;
    private  Product  product;
}
