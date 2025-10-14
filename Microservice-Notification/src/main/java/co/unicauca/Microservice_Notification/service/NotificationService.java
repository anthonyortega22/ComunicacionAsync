package co.unicauca.Microservice_Notification.service;

import co.unicauca.Microservice_Notification.entity.AnteProyecto;
import co.unicauca.Microservice_Notification.entity.JefeDepartamento;
import co.unicauca.Microservice_Notification.repository.JefeDepartamentoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private JefeDepartamentoRepository jefeRepo;

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    public void procesarNotificacion(AnteProyecto anteproyecto) {

        log.info("🚀 Procesando notificaciones para el anteproyecto: {}", anteproyecto.getTitulo());

        // === Notificar a cada jefe de departamento ===
        if (anteproyecto.getDepartamento() != null && !anteproyecto.getDepartamento().isEmpty()) {
            for (String nombreDepto : anteproyecto.getDepartamento()) {
                JefeDepartamento jefe = jefeRepo.findByDepartamento(nombreDepto)
                        .orElseThrow(() -> new RuntimeException(
                                "No se encontró jefe para el departamento: " + nombreDepto
                        ));

                log.info("📩 [EMAIL SIMULADO - Jefe de Departamento]");
                log.info("De: sistema@universidad.edu.co");
                log.info("Para: {}", jefe.getGmail());
                log.info("Asunto: Nuevo anteproyecto recibido - {}", anteproyecto.getTitulo());
                log.info("Body: Estimado/a {}, se ha registrado un nuevo anteproyecto asociado a su departamento '{}'.",
                        jefe.getNombre(), nombreDepto);
            }
        }

        // === Notificar a cada docente ===
        List<String> correosDocentes = anteproyecto.getGmailDocente();
        if (correosDocentes != null && !correosDocentes.isEmpty()) {
            for (String correo : correosDocentes) {
                log.info("📩 [EMAIL SIMULADO - Docente]");
                log.info("De: sistema@universidad.edu.co");
                log.info("Para: {}", correo);
                log.info("Asunto: Registro de nuevo anteproyecto - {}", anteproyecto.getTitulo());
                log.info("Body: Estimado/a docente, se le ha asignado el anteproyecto '{}'.", anteproyecto.getTitulo());
            }
        }

        // === Notificar a cada estudiante ===
        List<String> correosEstudiantes = anteproyecto.getGmailEstudiante();
        if (correosEstudiantes != null && !correosEstudiantes.isEmpty()) {
            for (String correo : correosEstudiantes) {
                log.info("📩 [EMAIL SIMULADO - Estudiante]");
                log.info("De: sistema@universidad.edu.co");
                log.info("Para: {}", correo);
                log.info("Asunto: Confirmación de registro de anteproyecto - {}", anteproyecto.getTitulo());
                log.info("Body: Estimado/a estudiante, su anteproyecto '{}' ha sido registrado exitosamente.",
                        anteproyecto.getTitulo());
            }
        }

        log.info("✅ Todas las notificaciones individuales fueron enviadas correctamente para '{}'.",
                anteproyecto.getTitulo());
    }
}
