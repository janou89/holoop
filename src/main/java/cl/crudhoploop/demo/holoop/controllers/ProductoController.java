package cl.crudhoploop.demo.holoop.controllers;

import cl.crudhoploop.demo.holoop.models.entity.Producto;
import cl.crudhoploop.demo.holoop.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<List<Producto>> test() throws Exception{
        List<Producto> productos = null;
        try {
            return ResponseEntity.ok(productoService.getProductos());
        }catch (Exception e){
            throw e;
        }
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<Producto> newProducto(@RequestBody Producto producto) throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(productoService.createProducto(producto));
        }catch(Exception e){
            throw e;
        }
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProducto(@PathVariable("id") Integer producto_id) throws Exception{
        try{
            productoService.deleteProducto(producto_id);
            return new ResponseEntity<String>("Producto eliminado", HttpStatus.OK);
        }catch(Exception e){
            throw e;
        }
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional> getProductoById(@PathVariable("id") Integer producto_id) throws Exception{
        try{
           return ResponseEntity.ok(productoService.getProductoById(producto_id));
        }catch(Exception e){
            throw e;
        }
    }

    @RequestMapping(value="", method = RequestMethod.PUT)
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(productoService.updateProducto(producto));
        }catch(Exception e){
            throw e;
        }
    }
}
