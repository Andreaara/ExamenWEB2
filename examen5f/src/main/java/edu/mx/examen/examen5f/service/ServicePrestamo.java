package edu.mx.examen.examen5f.service;


import edu.mx.examen.examen5f.dto.PrestamoDto;
import edu.mx.examen.examen5f.model.Equipo.BeanEquipo;
import edu.mx.examen.examen5f.model.Equipo.RepositoryEquipo;
import edu.mx.examen.examen5f.model.Prestamo.BeanPrestamo;
import edu.mx.examen.examen5f.model.Prestamo.RepositoryPrestamo;
import edu.mx.examen.examen5f.model.Usuario.BeanUsuario;
import edu.mx.examen.examen5f.model.Usuario.RepositoryUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePrestamo {


    private RepositoryPrestamo repositoryPrestamo;
    private RepositoryUsuario repositoryUsuario;
    private RepositoryEquipo repositoryEquipo;

    public ServicePrestamo(RepositoryPrestamo repositoryPrestamo, RepositoryUsuario repositoryUsuario, RepositoryEquipo repositoryEquipo) {
        this.repositoryPrestamo = repositoryPrestamo;
        this.repositoryUsuario = repositoryUsuario;
        this.repositoryEquipo = repositoryEquipo;
    }

    public BeanPrestamo crearPrestamo(PrestamoDto datos) {

        BeanUsuario usuario = repositoryUsuario.findById(datos.getId_user().getId()).orElseThrow();
        BeanEquipo equipo = repositoryEquipo.findById(datos.getId_Equi().getId()).orElseThrow();



        boolean usuarioActivo = usuario.getActivo();
        boolean equipoDisponible = equipo.getDisponible();

        BeanPrestamo beanPrestamo = new BeanPrestamo();

        beanPrestamo.setFechaSolicitud(datos.getFechaSoli());
        beanPrestamo.setFechaDevolucion(datos.getFechaDevo());
        beanPrestamo.setId_usuario(datos.getId_user());
        beanPrestamo.setId_equipo(datos.getId_Equi().getId_equipo());
        beanPrestamo.setEstado(datos.getStado());

        if (usuarioActivo && equipoDisponible) {
            beanPrestamo.setEstado("solicitado");
        } else {

            beanPrestamo.setEstado("rechazado");
        }

        return repositoryPrestamo.save(beanPrestamo);



    }

    public List<BeanPrestamo> lista(){
        return repositoryPrestamo.findAll();
    }


    public BeanPrestamo aprobarPrestamo(Integer idPrestamo) {

        BeanPrestamo prestamo = repositoryPrestamo.findById(idPrestamo).orElseThrow();

        if ("solicitado".equals(prestamo.getEstado())) {
            prestamo.setEstado("aprobado");


            BeanEquipo equipo = prestamo.getId_equipo();
            equipo.setDisponible(false);

            repositoryEquipo.save(equipo);
        }

        return repositoryPrestamo.save(prestamo);
    }


    public BeanPrestamo registrarDevolucion(Integer idPrestamo) {

        BeanPrestamo prestamo = repositoryPrestamo.findById(Math.toIntExact(idPrestamo)).orElseThrow();
        prestamo.setEstado("devuelto");


        BeanEquipo equipo = prestamo.getId_equipo();
        equipo.setDisponible(true);


        repositoryEquipo.save(equipo);

        return repositoryPrestamo.save(prestamo);
    }

    public List<BeanEquipo> busquedaNombre(String nombre){
        return repositoryEquipo.findAll().stream().
                filter(p->p.getNombre().equals(nombre))
                .toList();
    }

}
