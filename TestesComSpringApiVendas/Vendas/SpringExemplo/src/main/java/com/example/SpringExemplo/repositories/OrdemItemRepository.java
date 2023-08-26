package com.example.SpringExemplo.repositories;

import com.example.SpringExemplo.entites.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemItemRepository extends JpaRepository<OrderItem,Long> {
}
