package co.unicauca.repository;

import co.unicauca.entity.Anteproyecto;
import co.unicauca.entity.Docente;
import co.unicauca.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {


    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private AnteproyectoRepository anteproyectoRepository;

    @Override
    public void run(String... args) throws Exception {

        Estudiante e1 = new Estudiante();
        e1.setNombre("Nicolle Montaño");
        e1.setCorreo("nicolle.montano@unicauca.edu.co");

        Estudiante e2 = new Estudiante();
        e2.setNombre("Juan Pérez");
        e2.setCorreo("juan.perez@unicauca.edu.co");

        Estudiante e3 = new Estudiante();
        e3.setNombre("Laura Gómez");
        e3.setCorreo("laura.gomez@unicauca.edu.co");

        estudianteRepository.saveAll(Arrays.asList(e1, e2, e3));


        Docente d1 = new Docente();
        d1.setNombre("Carlos Arteaga");
        d1.setCorreo("carlos.arteaga@unicauca.edu.co");
        d1.setDepartamento("Electronica");

        Docente d2 = new Docente();
        d2.setNombre("María Soto");
        d2.setCorreo("maria.soto@unicauca.edu.co");
        d2.setDepartamento("Sistemas");

        Docente d3 = new Docente();
        d3.setNombre("Andrés Torres");
        d3.setCorreo("andres.torres@unicauca.edu.co");
        d3.setDepartamento("Sistemas");

        docenteRepository.saveAll(Arrays.asList(d1, d2, d3));

        Anteproyecto anteproyecto = new Anteproyecto();
        anteproyecto.setTitulo("Sistema Inteligente para la Gestión de Proyectos de Grado");

        List<Estudiante> estudiantes = Arrays.asList(e1, e2);
        List<Docente> docentes = Arrays.asList(d1, d2);

        anteproyecto.setEstudiantes(estudiantes);
        anteproyecto.setDocentes(docentes);

        anteproyectoRepository.save(anteproyecto);

        System.out.println(" Datos iniciales cargados correctamente:");
        System.out.println("- Estudiantes: " + estudianteRepository.count());
        System.out.println("- Docentes: " + docenteRepository.count());
        System.out.println("- Anteproyectos: " + anteproyectoRepository.count());
    }
}

