package com.breaze.PrimeraApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "usuarioRoles")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="username", nullable = false, unique = true, length = 100)
    private String username;
    @Column(name="password", nullable = false, length = 255)
    private String password;
    @Column(name="activo", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean activo;
    @Column(name="created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "usuario")
    private List<UsuarioRol> usuarioRoles;
}
