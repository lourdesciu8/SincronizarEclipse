package com.example.evaluable3.Services;


import com.example.evaluable3.model.Coleccion;
import java.util.List;

public interface ColeccionesService {
    List<Coleccion> findAll();
    Coleccion findById(Long id);
    Coleccion save(Coleccion coleccion);
    Coleccion update(Long id, Coleccion coleccion);
    void delete(Long id);
}
