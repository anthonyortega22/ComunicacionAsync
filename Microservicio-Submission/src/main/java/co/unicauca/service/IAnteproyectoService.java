package co.unicauca.service;

import co.unicauca.entity.Anteproyecto;
import co.unicauca.infra.dto.AnteproyectoRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IAnteproyectoService {
    @Transactional
    Anteproyecto crearAnteproyecto(AnteproyectoRequest request) throws Exception;
    @Transactional
    Optional<Anteproyecto> buscarPorId(Long id);
    @Transactional
    List<Anteproyecto> listarAnteproyectos() throws Exception;
}
