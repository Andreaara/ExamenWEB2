package edu.mx.examen.examen5f.model.Prestamo;


import edu.mx.examen.examen5f.model.Equipo.BeanEquipo;
import edu.mx.examen.examen5f.model.Usuario.BeanUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Prestamo")
public class BeanPrestamo {

   @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer id;
   private String fechaSolicitud;
   private String fechaDevolucion;

   @ManyToOne
    private BeanUsuario id_usuario;

   @ManyToOne
    private BeanEquipo id_equipo;

   private String estado ;



}
