package com.breaze.PrimeraApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "libro_categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"libro", "categoria"})
public class LibroCategoria {

    @EmbeddedId
    private LibroCategoriaId id;

    @Column(name = "prioridad")
    private Integer prioridad;

    @Column(name = "added_at", insertable = false, updatable = false)
    private LocalDateTime addedAt;

    @Column(name = "comentario", length = 255)
    private String comentario;

    @ManyToOne
    @MapsId("libroId")
    @JoinColumn(name = "libro_id")
    private Libro libro;

    @ManyToOne
    @MapsId("categoriaId")
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
