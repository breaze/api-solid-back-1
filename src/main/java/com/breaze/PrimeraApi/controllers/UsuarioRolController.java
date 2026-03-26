package com.breaze.PrimeraApi.controllers;


import com.breaze.PrimeraApi.dtos.UsuarioRolResponse;
import com.breaze.PrimeraApi.entities.UsuarioRol;
import com.breaze.PrimeraApi.services.IUsuarioRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario-roles")
@RequiredArgsConstructor
public class UsuarioRolController {

    private final IUsuarioRolService usuarioRolService;

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<UsuarioRolResponse>> findByUsuarioId(@PathVariable Long usuarioId){
        List<UsuarioRolResponse> responses = usuarioRolService.findByUsuarioId(usuarioId)
                .stream()
                .map(this::toResponse).toList();
        return ResponseEntity.ok(responses);
    }

    private UsuarioRolResponse toResponse(UsuarioRol ur){
        UsuarioRolResponse response = new UsuarioRolResponse();
        if(ur.getId()!=null){
            response.setUsuarioId(ur.getId().getUsuarioId());
            response.setRolId(ur.getId().getRolId());
        }
        if(ur.getUsuario()!=null){
            response.setUsername(ur.getUsuario().getUsername());
        }
        if(ur.getRol()!=null){
            response.setRolNombre(ur.getRol().getNombre());
        }
        return response;
    }
}
