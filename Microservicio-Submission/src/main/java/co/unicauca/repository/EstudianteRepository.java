package co.unicauca.repository;

import co.unicauca.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
    Optional<Estudiante> findByCorreo(String correo);
}
