package com.breaze.PrimeraApi.services.impl;

import com.breaze.PrimeraApi.entities.UsuarioRol;
import com.breaze.PrimeraApi.entities.UsuarioRolId;
import com.breaze.PrimeraApi.repositories.IUsuarioRolRepository;
import com.breaze.PrimeraApi.services.IUsuarioRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioRolServiceImpl implements IUsuarioRolService {

    private final IUsuarioRolRepository usuarioRolRepository;

    @Override
    public List<UsuarioRol> findByUsuarioId(Long usuarioId) {
        return usuarioRolRepository.findByIdUsuarioId(usuarioId);
    }

    @Override
    public List<UsuarioRol> findByRolId(Long rolId) {
        return usuarioRolRepository.findByIdRolId(rolId);
    }

    @Override
    public UsuarioRol save(UsuarioRol usuarioRol) {
        return usuarioRolRepository.save(usuarioRol);
    }

    @Override
    public boolean delete(UsuarioRolId id) {
        if(!usuarioRolRepository.existsById(id)) return false;
        usuarioRolRepository.deleteById(id);
        return true;
    }
}
