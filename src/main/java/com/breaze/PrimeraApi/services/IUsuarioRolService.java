package com.breaze.PrimeraApi.services;

import com.breaze.PrimeraApi.entities.UsuarioRol;
import com.breaze.PrimeraApi.entities.UsuarioRolId;

import java.util.List;

public interface IUsuarioRolService {
    List<UsuarioRol> findByUsuarioId(Long usuarioId);
    List<UsuarioRol> findByRolId(Long rolId);
    UsuarioRol save(UsuarioRol usuarioRol);
    boolean delete(UsuarioRolId id);
}
