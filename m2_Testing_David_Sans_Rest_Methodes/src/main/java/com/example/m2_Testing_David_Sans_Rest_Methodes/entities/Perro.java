package com.example.m2_Testing_David_Sans_Rest_Methodes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Perro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    private Long id;
    private String chip;
    private String name;
    private  String raza;
    private String sexo;
    private Double peso;
    private Boolean licencia;
    private Integer adopciones;

    public Perro() {
    }

    public Perro(Long id, String chip, String name, String raza, String sexo, Double peso,  Boolean licencia, Integer adopciones) {
        this.id = id;
        this.chip = chip;
        this.name = name;
        this.raza = raza;
        this.sexo = sexo;
        this.peso = peso;
        this.licencia = licencia;
        this.adopciones = adopciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }


    public Boolean getLicencia() {
        return licencia;
    }

    public void setLicencia(Boolean licencia) {
        this.licencia = licencia;
    }

    public Integer getAdopciones() {
        return adopciones;
    }

    public void setAdopciones(Integer adopciones) {
        this.adopciones = adopciones;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "id=" + id +
                ", chip=" + chip +
                ", name='" + name + '\'' +
                ", raza='" + raza + '\'' +
                ", sexo='" + sexo + '\'' +
                ", peso=" + peso +
                ", licencia=" + licencia +
                ", adopciones=" + adopciones +
                '}';
    }
}

