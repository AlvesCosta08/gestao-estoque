package com.gestao_estoque.gestao_estoque.repository;

import com.gestao_estoque.gestao_estoque.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
