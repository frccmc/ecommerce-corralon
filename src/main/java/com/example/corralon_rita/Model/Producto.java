package com.example.corralon_rita.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private Double precio;
  private String categoria;
  public static ArrayList<Producto> carrito = new ArrayList<>();

  //constructor
  public Producto(String nombre, double precio, String categoria) {
    this.nombre = nombre;
    this.precio = precio;
    this.categoria = categoria;
  }

  public Producto() {
  }

  //getters y setters
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public void setPrecio(Double precio) {
    this.precio = precio;
  }
  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }
  public double getPrecio() {
    return precio;
  }
  public String getCategoria() {
    return categoria;
  }
  public Long getId() {
    return id;
  }

}
