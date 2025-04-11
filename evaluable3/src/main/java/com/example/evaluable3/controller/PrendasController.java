package com.example.evaluable3.controller;

import com.example.evaluable3.model.Prenda;
import com.example.evaluable3.Services.PrendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prendas")
public class PrendasController {

    @Autowired
    private PrendasService prendasService;

    // Obtener todas las prendas
    @GetMapping("/info")
    public List<Prenda> getAllPrendas() {
        return prendasService.findAll();
    }

    @GetMapping("/conexion")
    public String conexionCorrecta(){
        return "Conexión realizada correctamente";
    }

    // Obtener una prenda por ID
    @GetMapping("/{id}")
    public ResponseEntity<Prenda> getPrendaById(@PathVariable Long id) {
        Prenda prenda = prendasService.findById(id);
        if (prenda != null) {
            return ResponseEntity.ok(prenda);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear una nueva prenda
    @PostMapping
    public Prenda createPrenda(@RequestBody Prenda prenda) {
        return prendasService.save(prenda);
    }

    // Actualizar una prenda existente
    @PutMapping("/{id}")
    public ResponseEntity<Prenda> updatePrenda(@PathVariable Long id,
                                               @RequestBody Prenda prendaDetails) {
        Prenda updated = prendasService.update(id, prendaDetails);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar una prenda
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrenda(@PathVariable Long id) {
        prendasService.delete(id);
        return ResponseEntity.ok("La prenda ha sido eliminada");
    }

    // Obtener todas las prendas de una colección específica
    @GetMapping("/coleccion/{coleccionId}")
    public List<Prenda> getPrendasByColeccion(@PathVariable Long coleccionId) {
        return prendasService.findByColeccionId(coleccionId);
    }


}
