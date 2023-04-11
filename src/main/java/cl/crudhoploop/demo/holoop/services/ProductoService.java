package cl.crudhoploop.demo.holoop.services;

import cl.crudhoploop.demo.holoop.models.entity.Producto;
import cl.crudhoploop.demo.holoop.models.repository.IProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private IProductosRepository iProductosRepository;

    public List<Producto> getProductos() throws Exception{
        try{
            return iProductosRepository.findAll();
        }catch (Exception e){
            throw e;
        }
    }

    public Optional<Producto> getProductoById(Integer id) throws Exception{
        try{
            return iProductosRepository.findById(id);
        }catch(Exception e){
            throw e;
        }
    }

    public Producto createProducto(Producto producto) throws Exception{
        try{
            return (producto.getProducto_id() == null)?iProductosRepository.save(producto):null;
        }catch(Exception e){
            throw e;
        }
    }

    public Producto updateProducto(Producto producto) throws Exception{
        try{
            return (producto.getProducto_id() != null && iProductosRepository.existsById(producto.getProducto_id()))?iProductosRepository.save(producto):null;
        }catch(Exception e){
            throw e;
        }
    }

    public void deleteProducto(Integer producto_id) throws Exception{
        try{
            iProductosRepository.deleteById(producto_id);
        }catch(Exception e){
            throw e;
        }
    }


}
