package co.unicauca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String correo;
    private String departamento;


    public Docente(Long id, String nombre, String correo, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;
    }

    public Docente() {
    }
}
