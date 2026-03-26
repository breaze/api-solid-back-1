package com.breaze.PrimeraApi.services.impl;

import com.breaze.PrimeraApi.entities.Usuario;
import com.breaze.PrimeraApi.repositories.IUsuarioRepository;
import com.breaze.PrimeraApi.services.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {
    private final IUsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> findByUserName(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> update(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).map(existing -> {
            existing.setUsername(usuario.getUsername());
            existing.setPassword(usuario.getPassword());
            existing.setActivo(usuario.getActivo());
            return usuarioRepository.save(existing);
        });
    }

    @Override
    public boolean delete(Long id) {
        if(!usuarioRepository.existsById(id)) return false;
        usuarioRepository.deleteById(id);
        return true;
    }
}
