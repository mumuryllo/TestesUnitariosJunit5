package com.example.SpringExemplo.services;

import com.example.SpringExemplo.entites.Order;
import com.example.SpringExemplo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> listarPedidos(){
        return  orderRepository.findAll();
    }

    public Order listarPedidoId (Long id){
        Optional<Order> obj=orderRepository.findById(id);
        return obj.get();
    }

}
