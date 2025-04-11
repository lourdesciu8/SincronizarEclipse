package com.example.evaluable3.Services.implementation;


import com.example.evaluable3.model.Coleccion;
import com.example.evaluable3.repository.ColeccionesRepository;
import com.example.evaluable3.Services.ColeccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColeccionesServiceImpl implements ColeccionesService {

    @Autowired
    private ColeccionesRepository coleccionRepository;

    @Override
    public List<Coleccion> findAll() {
        return coleccionRepository.findAll();
    }

    @Override
    public Coleccion findById(Long id) {
        return coleccionRepository.findById(id).orElse(null);
    }

    @Override
    public Coleccion save(Coleccion coleccion) {
        return coleccionRepository.save(coleccion);
    }

    @Override
    public Coleccion update(Long id, Coleccion coleccionDetails) {
        Coleccion coleccion = coleccionRepository.findById(id).orElse(null);
        if (coleccion != null) {
            coleccion.setNombre(coleccionDetails.getNombre());
            coleccion.setTemporada(coleccionDetails.getTemporada());
            coleccion.setAnio(coleccionDetails.getAnio());
            return coleccionRepository.save(coleccion);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (coleccionRepository.existsById(id)) {
            coleccionRepository.deleteById(id);
        }
    }
}
