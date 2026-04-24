package com.example.lab04.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;

@Entity
@Table(name = "endpoints")
public class Endpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Column(name = "ruta")
    private String ruta;

    public String getRuta() {return ruta;}
    public void setRuta(String ruta) {this.ruta = ruta;}

    @Column(name = "metodo_http")
    private String metodo_http;

    public String getMetodo_http() {return metodo_http;}
    public void setMetodo_http(String metodo_http) {this.metodo_http = metodo_http;}

    @Column(name= "descripcion")
    private String descripcion;

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "api_id")
    private Api api;

    public void setApi(Api api) {this.api = api;}
    public Api getApi() {return api;}

    public Endpoint() {}

}
