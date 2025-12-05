package com.example.corralon_rita.Service;

import com.example.corralon_rita.Model.Producto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

  public Producto agregarProducto (Producto producto);
  public List<Producto> buscarProductos(String nombre, Double precio);
  public Producto editarProducto(Long id, String nuevoNombre, Double nuevoPrecio);
  public Producto borrarProducto(Long id);
}
