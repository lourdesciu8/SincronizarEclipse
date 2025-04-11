package com.example.evaluable3.Services;


import com.example.evaluable3.model.Prenda;
import java.util.List;

public interface PrendasService {
    List<Prenda> findAll();
    Prenda findById(Long id);
    Prenda save(Prenda prenda);
    Prenda update(Long id, Prenda prenda);
    void delete(Long id);
    List<Prenda> findByColeccionId(Long coleccionId);
}
