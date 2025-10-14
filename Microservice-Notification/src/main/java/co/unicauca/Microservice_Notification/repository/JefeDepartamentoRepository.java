package co.unicauca.Microservice_Notification.repository;

import co.unicauca.Microservice_Notification.entity.JefeDepartamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JefeDepartamentoRepository  extends JpaRepository<JefeDepartamento, Long> {

    Optional<JefeDepartamento> findByDepartamento(String departamento);

}
