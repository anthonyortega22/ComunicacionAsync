package co.unicauca.Microservice_Notification.infra.config;

import co.unicauca.Microservice_Notification.entity.JefeDepartamento;
import co.unicauca.Microservice_Notification.repository.JefeDepartamentoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private JefeDepartamentoRepository jefeRepo;

    @PostConstruct
    public void initData() {
        if (jefeRepo.count() == 0) {
            JefeDepartamento jefe1 = new JefeDepartamento();
            jefe1.setNombre("Carlos López");
            jefe1.setDepartamento("Ingeniería de Sistemas");
            jefe1.setGmail("carlos.lopez@unicauca.edu.co");

            JefeDepartamento jefe2 = new JefeDepartamento();
            jefe2.setNombre("María Gómez");
            jefe2.setDepartamento("Ingeniería Electrónica");
            jefe2.setGmail("maria.gomez@unicauca.edu.co");

            JefeDepartamento jefe3 = new JefeDepartamento();
            jefe3.setNombre("Juan Pérez");
            jefe3.setDepartamento("Ingeniería Civil");
            jefe3.setGmail("juan.perez@unicauca.edu.co");

            jefeRepo.save(jefe1);
            jefeRepo.save(jefe2);
            jefeRepo.save(jefe3);

            System.out.println("✅ Datos iniciales de jefes de departamento insertados correctamente.");
        }
    }
}

