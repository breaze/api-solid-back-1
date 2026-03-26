package com.breaze.PrimeraApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "libroCategorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre",  nullable = false, unique = true, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private List<LibroCategoria> libroCategorias;
}
