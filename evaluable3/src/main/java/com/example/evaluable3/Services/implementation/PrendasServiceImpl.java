package com.example.evaluable3.Services.implementation;

import com.example.evaluable3.model.Prenda;
import com.example.evaluable3.repository.PrendasRepository;
import com.example.evaluable3.Services.PrendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendasServiceImpl implements PrendasService {

    @Autowired
    private PrendasRepository prendaRepository;

    @Override
    public List<Prenda> findAll() {
        return prendaRepository.findAll();
    }

    @Override
    public Prenda findById(Long id) {
        return prendaRepository.findById(id).orElse(null);
    }

    @Override
    public Prenda save(Prenda prenda) {
        return prendaRepository.save(prenda);
    }

    @Override
    public Prenda update(Long id, Prenda prendaDetails) {
        Prenda prenda = prendaRepository.findById(id).orElse(null);
        if (prenda != null) {
            prenda.setNombre(prendaDetails.getNombre());
            prenda.setDescripcion(prendaDetails.getDescripcion());
            prenda.setTalla(prendaDetails.getTalla());
            prenda.setColor(prendaDetails.getColor());
            prenda.setPrecio(prendaDetails.getPrecio());
            prenda.setColeccion(prendaDetails.getColeccion());
            return prendaRepository.save(prenda);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (prendaRepository.existsById(id)) {
            prendaRepository.deleteById(id);
        }
    }

    @Override
    public List<Prenda> findByColeccionId(Long coleccionId) {
        return prendaRepository.findByColeccionIdColeccion(coleccionId);
    }
}
