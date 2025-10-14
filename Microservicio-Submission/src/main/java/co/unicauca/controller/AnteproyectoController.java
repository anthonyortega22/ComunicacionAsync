package co.unicauca.controller;

import co.unicauca.entity.Anteproyecto;
import co.unicauca.infra.dto.AnteproyectoRequest;
import co.unicauca.service.AnteproyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/submission")
public class AnteproyectoController {
    @Autowired
    private AnteproyectoService anteproyectoService;

    @PostMapping("/anteproyectos")
    public ResponseEntity<?> createAnteproyecto(@RequestBody AnteproyectoRequest anteproyectoRequest) {
        try {
            Anteproyecto saved = anteproyectoService.crearAnteproyecto(anteproyectoRequest);
            return ResponseEntity.ok(saved);
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error al guardar el anteproyecto.\"}");
        }
    }

    @GetMapping("/anteproyectos")
    public ResponseEntity<?> getAllAnteproyectos() {
        try {
            List<Anteproyecto> anteproyectos = anteproyectoService.listarAnteproyectos();
            if (anteproyectos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(anteproyectos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"Error al recuperar los anteproyectos.\"}");
        }
    }

    @GetMapping("/anteproyectos/{id}")
    public ResponseEntity<?> getAnteproyectoById(@PathVariable Long id) {
        try {
            Optional<Anteproyecto> anteproyecto = anteproyectoService.buscarPorId(id);
            if (anteproyecto.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"error\":\"Anteproyecto no encontrado.\"}");
            }
            return ResponseEntity.ok(anteproyecto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"Error al recuperar el anteproyecto.\"}");
        }
    }

}


