package com.example.evaluable3.controller;

import com.example.evaluable3.model.Coleccion;
import com.example.evaluable3.Services.ColeccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colecciones")
public class ColeccionesController {

    @Autowired
    private ColeccionesService coleccionesService;

    // Obtener todas las colecciones
    @GetMapping("/info")
    public List<Coleccion> getAllColecciones() {
        return coleccionesService.findAll();
    }

    @GetMapping("/conexion")
    public String conexionCorrecta(){
        return "Conexión realizada correctamente";
    }

    // Obtener una colección por ID
    @GetMapping("/{id}")
    public ResponseEntity<Coleccion> getColeccionById(@PathVariable Long id) {
        Coleccion coleccion = coleccionesService.findById(id);
        if (coleccion != null) {
            return ResponseEntity.ok(coleccion);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear una nueva colección
    @PostMapping
    public Coleccion createColeccion(@RequestBody Coleccion coleccion) {
        return coleccionesService.save(coleccion);
    }

    // Actualizar una colección existente
    @PutMapping("/{id}")
    public ResponseEntity<Coleccion> updateColeccion(@PathVariable Long id,
                                                     @RequestBody Coleccion coleccionDetails) {
        Coleccion updated = coleccionesService.update(id, coleccionDetails);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar una colección
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteColeccion(@PathVariable Long id) {
        coleccionesService.delete(id);
        return ResponseEntity.ok("La colección ha sido eliminada");
    }

}
