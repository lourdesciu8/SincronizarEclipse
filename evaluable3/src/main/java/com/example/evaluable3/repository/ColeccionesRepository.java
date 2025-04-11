package com.example.evaluable3.repository;


import com.example.evaluable3.model.Coleccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColeccionesRepository extends JpaRepository<Coleccion, Long> {
}
