package com.breaze.PrimeraApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"detalleLibro", "librosCategorias"})
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;

    @Column(name="created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name="updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @OneToOne(mappedBy = "libro")
    private DetalleLibro detalleLibro;
    @OneToMany(mappedBy = "libro")
    private List<LibroCategoria> librosCategorias;
}
