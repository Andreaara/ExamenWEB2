package edu.mx.examen.examen5f.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryUsuario extends JpaRepository<BeanUsuario, Integer> {
}
