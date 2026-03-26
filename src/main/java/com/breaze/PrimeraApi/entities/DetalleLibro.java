package com.breaze.PrimeraApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "detalle_libro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "libro")
public class DetalleLibro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "isbn", unique = true, nullable = false, length = 20)
    private String isbn;

    @Column(name = "num_paginas")
    private Integer numeroPaginas;

    @Column(name = "idioma", length = 50)
    private String idioma;

    @OneToOne
    @JoinColumn(name = "libro_id", nullable = false, unique = true)
    private Libro libro;
}
