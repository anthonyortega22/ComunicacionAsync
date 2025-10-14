package co.unicauca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name="anteproyecto")
public class Anteproyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String titulo;

    @OneToMany
    @JoinColumn(name = "anteproyecto_id")
    private List<Estudiante> estudiantes;

    @ManyToMany
    @JoinTable(
            name = "anteproyecto_docente",
            joinColumns = @JoinColumn(name = "anteproyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "docente_id")
    )
    private List<Docente> docentes;

}
