package co.unicauca.Microservice_Notification.entity;

import lombok.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
public class AnteProyecto {
    private Long id;
    private String titulo;

    // Estos nombres deben coincidir con el JSON exacto
    private List<String> correosEstudiantes;
    private List<String> correosDocentes;
    private List<String> departamentosDocentes;

    public AnteProyecto(Long id, String titulo, List<String> correosEstudiantes, List<String> correosDocentes, List<String> departamentosDocentes) {
        this.id = id;
        this.titulo = titulo;
        this.correosEstudiantes = correosEstudiantes;
        this.correosDocentes = correosDocentes;
        this.departamentosDocentes = departamentosDocentes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getCorreosEstudiantes() {
        return correosEstudiantes;
    }

    public void setCorreosEstudiantes(List<String> correosEstudiantes) {
        this.correosEstudiantes = correosEstudiantes;
    }

    public List<String> getCorreosDocentes() {
        return correosDocentes;
    }

    public void setCorreosDocentes(List<String> correosDocentes) {
        this.correosDocentes = correosDocentes;
    }

    public List<String> getDepartamentosDocentes() {
        return departamentosDocentes;
    }

    public void setDepartamentosDocentes(List<String> departamentosDocentes) {
        this.departamentosDocentes = departamentosDocentes;
    }
}
