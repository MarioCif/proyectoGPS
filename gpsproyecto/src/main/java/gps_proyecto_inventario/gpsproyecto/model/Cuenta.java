package gps_proyecto_inventario.gpsproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    private int id_cuenta;
    private String password;
    private String user;
    private String correo;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public int getId_cuenta() {
        return id_cuenta;
    }
    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
}
