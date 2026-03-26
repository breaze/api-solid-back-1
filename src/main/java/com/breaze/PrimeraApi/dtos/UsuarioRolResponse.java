package com.breaze.PrimeraApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRolResponse {
    private Long usuarioId;
    private String username;
    private Long rolId;
    private String rolNombre;
}
