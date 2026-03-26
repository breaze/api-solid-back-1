package com.breaze.PrimeraApi.repositories;

import com.breaze.PrimeraApi.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);

    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.usuarioRoles ur LEFT JOIN FETCH ur.rol WHERE u.username = :username")
    Optional<Usuario> findByUsernameWithRoles(@Param("username") String username);
}