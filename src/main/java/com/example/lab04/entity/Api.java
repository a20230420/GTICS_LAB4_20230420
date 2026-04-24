package com.example.lab04.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "apis")
public class Api {
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

    @Column(name = "version")
    private String version;

    public String getVersion() {return version;}
    public void setVersion(String version) {this.version = version;}

    @Column(name = "fecha_registro")
    private Date fecha_registro;

    public Date getFecha_registro() {return fecha_registro;}
    public void setFecha_registro(Date fecha_registro) {this.fecha_registro = fecha_registro;}

    @Column(name = "estado")
    private String estado;

    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    public Equipo getEquipo() {return equipo;}
    public void setEquipo(Equipo equipo) {this.equipo = equipo;}

    public Api() {}

}
