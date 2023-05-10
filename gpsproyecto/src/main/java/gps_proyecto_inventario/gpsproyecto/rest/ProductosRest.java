package gps_proyecto_inventario.gpsproyecto.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gps_proyecto_inventario.gpsproyecto.model.Productos;
import gps_proyecto_inventario.gpsproyecto.service.ProductosService;

@RestController
@RequestMapping(value = "/productos")
@CrossOrigin(origins = "*")
public class ProductosRest {
    @Autowired
    private ProductosService proService;

    // HU01 getAllProductos
    @GetMapping("/carcasa")
    public ResponseEntity<List<Productos>> getAllProductos() {
        List<Productos> productos = proService.findAllProductos();
        if (!(productos.isEmpty())) {
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(productos, HttpStatus.NOT_FOUND);
        }
    }

    // HU03
    @PostMapping("")
    public ResponseEntity<Void> addProducto(@RequestBody Productos producto_nuevo) {
        boolean crearProducto = proService.AddProducto(producto_nuevo);
        if (crearProducto) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // HU04
    @GetMapping(value = "/carcasa/{SKU}")
    public ResponseEntity<Object> getCarcasaPorSKU(@PathVariable String SKU) {
        Optional<Productos> producto = proService.getCarcasaById(SKU);
        if (producto.isPresent()) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // HU05     
    @DeleteMapping(value = "/{SKU}")
    public ResponseEntity<Void>deleteProducto(@PathVariable String SKU){
        boolean eliminado=proService.deleteProducto(SKU);
        if(eliminado){
            return new ResponseEntity<>(HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // HU06
    @PutMapping("/carcasa/{SKU}")
    public ResponseEntity<Productos> updateProducto(@PathVariable String SKU,@RequestBody Productos producto_actualizado) {
        Optional<Productos> producto = proService.getCarcasaById(SKU);
        if (producto.isPresent()) {
            proService.UpdateProducto(producto_actualizado);
            return new ResponseEntity<>(producto_actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}