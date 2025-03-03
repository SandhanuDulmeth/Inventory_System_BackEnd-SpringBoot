package edu.sandhanu.ecom.controller;

import edu.sandhanu.ecom.model.Product;
import edu.sandhanu.ecom.serivce.custom.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/ProductController")
@RequiredArgsConstructor
public class ProductController {

    final ProductService productService;

    @GetMapping("/get-Items")
    public ArrayList<Product> getProduct() {

        return productService.getProduct();}


}
