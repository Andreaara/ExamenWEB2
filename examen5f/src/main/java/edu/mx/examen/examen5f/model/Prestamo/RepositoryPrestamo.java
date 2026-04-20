package edu.mx.examen.examen5f.model.Prestamo;

import edu.mx.examen.examen5f.model.Usuario.BeanUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPrestamo extends JpaRepository<BeanPrestamo, Integer> {

}
