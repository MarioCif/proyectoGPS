package gps_proyecto_inventario.gpsproyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gps_proyecto_inventario.gpsproyecto.model.Productos;
import gps_proyecto_inventario.gpsproyecto.repository.ProductosRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductosService {
    @Autowired
    private ProductosRepo pRepo;

    // HU01 -Servicio getAllProductos
    public List<Productos> findAllProductos() {
        return pRepo.findAll();
    }

    // HU03
    public boolean AddProducto(Productos pnuevo) {
        Optional<Productos> proOptional = pRepo.findById(pnuevo.getSKU());
        if (proOptional.isPresent() == false) {
            pRepo.InsertProducto(pnuevo.getSKU(),
                    pnuevo.getTipo(), pnuevo.getDescripcion(), pnuevo.getImagen(), pnuevo.getColor(),
                    pnuevo.getMaterial(), pnuevo.getModelo(), pnuevo.getPrecio(), pnuevo.getCantidad());
            return true;
        } else {
            return false;
        }
    }

    // HU04
    public Optional<Productos> getCarcasaById(String ID) {
        return pRepo.findById(ID);
    }

    // HU05
    public boolean deleteProducto(String SKU) {
        Optional<Productos> productoOptional = pRepo.findById(SKU);
        if (productoOptional.isPresent()) {
            pRepo.deleteById(SKU);
            return true;
        } else {
            return false;
        }
    }

    // HU06
    public boolean UpdateProducto(Productos pro_act) {
        Optional<Productos> productoOptional = pRepo.findById(pro_act.getSKU());
        if (productoOptional.isPresent()) {
            Productos productoExistente = productoOptional.get();
            productoExistente.setTipo(pro_act.getTipo());
            productoExistente.setDescripcion(pro_act.getDescripcion());
            productoExistente.setColor(pro_act.getColor());
            productoExistente.setMaterial(pro_act.getMaterial());
            productoExistente.setModelo(pro_act.getModelo());
            productoExistente.setPrecio(pro_act.getPrecio());
            productoExistente.setCantidad(pro_act.getCantidad());
            pRepo.saveAndFlush(productoExistente);
            return true;
        } else {
            return false;
        }
    }
}
