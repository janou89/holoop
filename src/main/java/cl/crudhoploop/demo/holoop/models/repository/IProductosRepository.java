package cl.crudhoploop.demo.holoop.models.repository;

import cl.crudhoploop.demo.holoop.models.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductosRepository extends JpaRepository<Producto, Integer> {
}
