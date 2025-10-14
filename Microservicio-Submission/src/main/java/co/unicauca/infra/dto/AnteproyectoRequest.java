package co.unicauca.infra.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnteproyectoRequest {
    private Long id;
    private String titulo;
    private List<String> correosEstudiantes;
    private List<String> correosDocentes;
    private List<String> departamentosDocentes;
}
