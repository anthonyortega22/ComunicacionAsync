package co.unicauca.Microservice_Notification.entity;

import lombok.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
public class AnteProyecto {
    private String titulo;
    private List<String> departamento;
    private List<String> gmailEstudiante;
    private List<String> gmailDocente;

    public AnteProyecto(String titulo, List<String> departamento, List<String> gmailEstudiante, List<String> gmailDocente) {
        this.titulo = titulo;
        this.departamento = departamento;
        this.gmailEstudiante = gmailEstudiante;
        this.gmailDocente = gmailDocente;
    }

    public AnteProyecto() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getDepartamento() {
        return departamento;
    }

    public void setDepartamento(List<String> departamento) {
        this.departamento = departamento;
    }

    public List<String> getGmailEstudiante() {
        return gmailEstudiante;
    }

    public void setGmailEstudiante(List<String> gmailEstudiante) {
        this.gmailEstudiante = gmailEstudiante;
    }

    public List<String> getGmailDocente() {
        return gmailDocente;
    }

    public void setGmailDocente(List<String> gmailDocente) {
        this.gmailDocente = gmailDocente;
    }
}
