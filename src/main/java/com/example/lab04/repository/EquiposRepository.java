package com.example.lab04.repository;

import com.example.lab04.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquiposRepository extends JpaRepository<Equipo, Integer> {
    List<Equipo> findAllByOrderByNombre();
}
