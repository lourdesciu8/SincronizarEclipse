package com.example.evaluable3.repository;

import com.example.evaluable3.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PrendasRepository extends JpaRepository<Prenda, Long> {
    // Método para obtener todas las prendas de una colección específica
    List<Prenda> findByColeccionIdColeccion(Long idColeccion);
}
