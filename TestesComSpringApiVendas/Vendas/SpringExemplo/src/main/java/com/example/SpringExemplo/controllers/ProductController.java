package com.example.SpringExemplo.controllers;

import com.example.SpringExemplo.entites.Product;
import com.example.SpringExemplo.entites.User;
import com.example.SpringExemplo.services.ProductService;
import com.example.SpringExemplo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list= productService.listarProdutos();
        return  ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = productService.listarProdutoId(id);
        return  ResponseEntity.ok().body(obj);
    }



}
