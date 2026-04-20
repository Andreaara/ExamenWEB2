package edu.mx.examen.examen5f.controller;


import edu.mx.examen.examen5f.dto.PrestamoDto;
import edu.mx.examen.examen5f.model.Equipo.BeanEquipo;
import edu.mx.examen.examen5f.model.Prestamo.BeanPrestamo;
import edu.mx.examen.examen5f.service.ServicePrestamo;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamo")
@CrossOrigin({"*"})
public class controllerPrestamo {

    private ServicePrestamo servicePrestamo;

    public controllerPrestamo(ServicePrestamo servicePrestamo) {
        this.servicePrestamo = servicePrestamo;
    }

    @GetMapping
    public List<BeanPrestamo> listaPrestamo(){
        return servicePrestamo.lista();
    }

    @PostMapping
    public BeanPrestamo crearPrestamo(@RequestBody PrestamoDto datos){
        return servicePrestamo.crearPrestamo(datos);
    }

    @PutMapping("/aprobar/{id}")
    public BeanPrestamo aprobar(@PathVariable Integer id) {
        return servicePrestamo.aprobarPrestamo(id);
    }


    @PutMapping("/devolver/{id}")
    public BeanPrestamo devolver(@PathVariable Integer id) {
        return servicePrestamo.registrarDevolucion(id);
    }

    @GetMapping("/Nombres")
    public List<BeanEquipo> listaNombres(String nombre){
        return servicePrestamo.busquedaNombre(nombre);
    }

}
