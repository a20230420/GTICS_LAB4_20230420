package com.example.lab04.repository;

import com.example.lab04.entity.Api;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApisRepository extends JpaRepository<Api, Integer> {
    List<Api> findAllByOrderByIdDesc();
}
