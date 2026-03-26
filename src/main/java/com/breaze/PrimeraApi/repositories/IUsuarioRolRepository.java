package com.breaze.PrimeraApi.repositories;

import com.breaze.PrimeraApi.entities.UsuarioRol;
import com.breaze.PrimeraApi.entities.UsuarioRolId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUsuarioRolRepository extends JpaRepository<UsuarioRol, UsuarioRolId> {
    List<UsuarioRol> findByIdUsuarioId(Long usuarioId);
    List<UsuarioRol> findByIdRolId(Long rolId);
}
