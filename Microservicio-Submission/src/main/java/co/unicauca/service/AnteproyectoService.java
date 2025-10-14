package co.unicauca.service;

import co.unicauca.entity.Anteproyecto;
import co.unicauca.entity.Docente;
import co.unicauca.entity.Estudiante;
import co.unicauca.infra.config.RabbitMQConfig;
import co.unicauca.infra.dto.AnteproyectoRequest;
import co.unicauca.repository.AnteproyectoRepository;
import co.unicauca.repository.DocenteRepository;
import co.unicauca.repository.EstudianteRepository;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnteproyectoService implements IAnteproyectoService{

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
        private AnteproyectoRepository anteproyectoRepository;

    @Autowired
        private EstudianteRepository estudianteRepository;

    @Autowired
        private DocenteRepository docenteRepository;

    @Override
    @Transactional
    public Anteproyecto crearAnteproyecto(AnteproyectoRequest request) throws Exception {
        try {
            // 1️⃣ Crear el objeto Anteproyecto
            Anteproyecto anteproyecto = new Anteproyecto();
            anteproyecto.setTitulo(request.getTitulo());

            // 2️⃣ Buscar los estudiantes por correo
            List<Estudiante> estudiantes = request.getCorreosEstudiantes()
                    .stream()
                    .map(estudianteRepository::findByCorreo)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();

            // 3️⃣ Buscar los docentes por correo
            List<Docente> docentes = request.getCorreosDocentes()
                    .stream()
                    .map(docenteRepository::findByCorreo)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();

            anteproyecto.setEstudiantes(estudiantes);
            anteproyecto.setDocentes(docentes);

            // 4️⃣ Guardar el anteproyecto en la BD
            Anteproyecto anteproyectoGuardado = anteproyectoRepository.save(anteproyecto);

            // 5️⃣ Enviar notificación al microservicio de notificaciones
            // Puedes enviar el objeto completo o solo los correos (recomendado: solo los datos necesarios)
            rabbitTemplate.convertAndSend(RabbitMQConfig.ANTEPROYECTO_QUEUE, request);

            return anteproyectoGuardado;

        } catch (Exception e) {
            throw new Exception("Error al crear el anteproyecto: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public Optional<Anteproyecto> buscarPorId(Long id) {
        return anteproyectoRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Anteproyecto> listarAnteproyectos() throws Exception {
        try {
            return anteproyectoRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error al listar los anteproyectos: " + e.getMessage());
        }
    }
}
