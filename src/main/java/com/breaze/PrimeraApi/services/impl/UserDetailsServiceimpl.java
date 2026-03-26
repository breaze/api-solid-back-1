package com.breaze.PrimeraApi.services.impl;

import com.breaze.PrimeraApi.repositories.IUsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceimpl implements UserDetailsService {
    private final IUsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuario = usuarioRepository.findByUsernameWithRoles(username)
                .orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado: "+ username));
        return null;
    }
}
