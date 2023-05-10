package gps_proyecto_inventario.gpsproyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gps_proyecto_inventario.gpsproyecto.model.Productos;

@Repository
public interface ProductosRepo extends JpaRepository<Productos, String>{
    @Modifying
    @Query(value = "Insert into productos (sku, tipo, descripcion, imagen, color, material, modelo, precio, cantidad) values (:sku, :tipo, :descripcion, :imagen, :color, :material, :modelo, :precio, :cantidad)", nativeQuery = true)
    void InsertProducto(@Param("sku") String sku, @Param("tipo") String tipo, @Param("descripcion") String descripcion, @Param("imagen") String imagen,
    @Param("color") String color, @Param("material") String material, @Param("modelo") String modelo, @Param("precio") float precio, @Param("cantidad") int cantidad); 
}
