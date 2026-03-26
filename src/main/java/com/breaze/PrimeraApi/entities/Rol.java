package com.breaze.PrimeraApi.entities;

import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "usuarioRoles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nombre", nullable = false, unique = true, length = 50)
    private String nombre;
    @OneToMany(mappedBy = "rol")
    private List<UsuarioRol> usuarioRoles;
}
