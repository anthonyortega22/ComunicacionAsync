package co.unicauca.Microservice_Notification.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "jefedepartamento")
public class JefeDepartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String gmail;
    private String departamento;

    public JefeDepartamento(Long id, String nombre, String gmail, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.gmail = gmail;
        this.departamento = departamento;
    }

    public JefeDepartamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
