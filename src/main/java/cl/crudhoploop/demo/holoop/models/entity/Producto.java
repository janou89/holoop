package cl.crudhoploop.demo.holoop.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer producto_id;
    String nombre;
    String descripcion;
    Integer precio;
    Integer stock;
    Integer categoria_id;
}
