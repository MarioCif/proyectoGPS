package gps_proyecto_inventario.gpsproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contiene")
public class Contiene {
    @Id
    private String id;
    
    @ManyToOne
    @JoinColumn
    private Carrito_de_Compras carrito;

    @ManyToOne
    @JoinColumn
    private Productos producto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Carrito_de_Compras getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito_de_Compras carrito) {
        this.carrito = carrito;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }    
}
