package com.example.lab04.repository;

import com.example.lab04.entity.Endpoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EndpointsRepository extends JpaRepository<Endpoint, Integer> {
}
