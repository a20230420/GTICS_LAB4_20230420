package com.example.lab04.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Column(name = "nombre")
    private String nombre;

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    @Column(name = "area")
    private String area;

    public String getArea() {return area;}
    public void setArea(String area) {this.area = area;}

    public Equipo() {}
}
