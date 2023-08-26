package com.example.SpringExemplo.services;

import com.example.SpringExemplo.entites.Product;
import com.example.SpringExemplo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listarProdutos(){
        return  productRepository.findAll();
    }

    public Product listarProdutoId (Long id){
        Optional<Product> obj=productRepository.findById(id);
        return obj.get();
    }

}
