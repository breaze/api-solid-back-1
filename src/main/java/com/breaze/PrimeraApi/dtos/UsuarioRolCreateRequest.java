package com.breaze.PrimeraApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRolCreateRequest {
    private Long usuarioId;
    private Long rolId;
}
