package com.example.corralon_rita.Controller;

import com.example.corralon_rita.Model.Producto;
import com.example.corralon_rita.Service.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
  private ProductService service;
  public ProductController(ProductService service) {
    this.service = service;
  }



  @PostMapping
  public Producto agregarProducto(@RequestBody Producto producto){
    return this.service.agregarProducto(producto); //el service crea un producto y se lo retorno al cliente (ver service)
  }

  @GetMapping
  public List<Producto> buscarPorNombreYPrecio(
      @RequestParam(required = false, defaultValue = "") String nombre,
      @RequestParam(required = false, defaultValue = "0") Double precio)
  {
    return this.service.buscarProductos(nombre, precio);
  };

  //Editar nombre y/o precio
  @PutMapping("/{id}")
  public Producto editarProducto(@PathVariable Long id, @RequestParam(required = false, defaultValue = "") String nombre,
      @RequestParam(required = false, defaultValue = "0") Double precio){
    return this.service.editarProducto(id, nombre, precio);
  };

  @DeleteMapping("/{id}")
  public Producto borrarProducto(@PathVariable Long id){
    return this.service.borrarProducto(id);
  };
}
