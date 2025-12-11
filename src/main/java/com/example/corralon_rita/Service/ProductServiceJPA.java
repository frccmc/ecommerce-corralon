package com.example.corralon_rita.Service;

import com.example.corralon_rita.Model.Producto;
import com.example.corralon_rita.Repository.ProductoRepository;
import java.text.Normalizer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceJPA implements ProductService {

  private ProductoRepository productoRepository;
  public ProductServiceJPA(ProductoRepository repository) {this.productoRepository = repository;}

  public Producto agregarProducto (Producto producto) {
    System.out.println("Creando producto");
    return this.productoRepository.save(producto);
  }
  public List<Producto> buscarProductos(String nombre, Double precio, String categoria){
    if (!nombre.isEmpty() && precio > 0 && !categoria.isEmpty()){
      return this.productoRepository.findByNombreContainingAndPrecioLessThanEqualAndCategoriaContaining(nombre, precio, categoria);
    }
    if (!nombre.isEmpty()) {
      return this.productoRepository.findByNombreContaining(nombre);
    }
    if(precio > 0){
      return this.productoRepository.findByPrecioLessThanEqual(precio);
    }
    if(!categoria.isEmpty()){
      return this.productoRepository.findByCategoriaContaining(categoria);
    }
    return this.productoRepository.findAll();
  }
  public Producto editarProducto(Long id, String nuevoNombre, Double nuevoPrecio, String nuevaCategoria) {
    Producto producto = this.productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    if(!nuevoNombre.isEmpty() && nuevoPrecio > 0 && !nuevaCategoria.isEmpty()){
      producto.setNombre(nuevoNombre);
      producto.setPrecio(nuevoPrecio);
      producto.setCategoria(nuevaCategoria);
      this.productoRepository.save(producto);
      return producto;
    } else if (!nuevoNombre.isEmpty()) {
      producto.setNombre(nuevoNombre);
      this.productoRepository.save(producto);
      return producto;
    } else if (nuevoPrecio > 0) {
      producto.setPrecio(nuevoPrecio);
      this.productoRepository.save(producto);
      return producto;
    } else if (!nuevaCategoria.isEmpty()) {
      producto.setCategoria(nuevaCategoria);
      this.productoRepository.save(producto);
      return producto;
    }

    return producto;
  }
  public Producto borrarProducto(Long id) {
    Optional<Producto> productoOptional = this.productoRepository.findById(id);
    if (productoOptional.isEmpty()) {
      System.out.println("No pudimos encontrar el producto :(");
      return null;
    }
    Producto producto = productoOptional.get();

    this.productoRepository.delete(producto);

    System.out.println("Producto borrado exitosamente");
    return producto;
  }
}
