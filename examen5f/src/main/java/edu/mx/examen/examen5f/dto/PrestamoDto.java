package edu.mx.examen.examen5f.dto;


import edu.mx.examen.examen5f.model.Prestamo.BeanPrestamo;
import edu.mx.examen.examen5f.model.Usuario.BeanUsuario;
import lombok.Data;

@Data
public class PrestamoDto {

    private String fechaSoli;
    private String fechaDevo;
    private BeanUsuario id_user;
    private BeanPrestamo id_Equi;
    private String stado;

}
