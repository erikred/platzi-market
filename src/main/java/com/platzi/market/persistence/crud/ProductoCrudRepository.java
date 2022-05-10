package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //Otra option de forma nativa y ya no seria necesario seguir la reglas para el nombre del método sin embargo se sugiere usar los QueryMethods
    //@Query(value = "SELECT * FROM productos WHERE id_categoria=?", nativeQuery = true)
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //Los QueryMethods también soportan operadores Optional para programación funcional
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
