package com.breaze.PrimeraApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "usuario_rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"usuario", "rol"})
public class UsuarioRol {
    @EmbeddedId
    private UsuarioRolId id;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @ManyToOne
    @MapsId("rolId")
    @JoinColumn(name="rol_id")
    private Rol rol;
}
