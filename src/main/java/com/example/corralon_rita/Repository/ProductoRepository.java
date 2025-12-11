package com.example.corralon_rita.Repository;

import com.example.corralon_rita.Model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
  List<Producto> findByNombreContaining(String nombre);
  List<Producto> findByPrecioLessThanEqual(Double precio);
  List<Producto>findByCategoriaContaining(String categoria);
  List<Producto> findByNombreContainingAndPrecioLessThanEqualAndCategoriaContaining(String nombre, Double precio, String categoria);
}
