package gps_proyecto_inventario.gpsproyecto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito_de_Compras {
    @Id
    private String id;
    private String forma_pago;
    private int cantidad_pro;
    private float total_pagar;
    private String detalles;
    private String estado;

    @OneToOne
    @JoinColumn(name = "rut_cliente")
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrito", orphanRemoval = true)
    private List<Contiene> carritos;

    public Carrito_de_Compras(){}

    public String getId_carrito() {
        return id;
    }

    public void setId_carrito(String id_carrito) {
        this.id = id_carrito;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public int getCantidad_pro() {
        return cantidad_pro;
    }

    public void setCantidad_pro(int cantidad_pro) {
        this.cantidad_pro = cantidad_pro;
    }

    public float getTotal_pagar() {
        return total_pagar;
    }

    public void setTotal_pagar(float total_pagar) {
        this.total_pagar = total_pagar;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Contiene> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Contiene> carritos) {
        this.carritos = carritos;
    }



}
