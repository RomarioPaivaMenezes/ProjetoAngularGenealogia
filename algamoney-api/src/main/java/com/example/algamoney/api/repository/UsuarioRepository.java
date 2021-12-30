package com.example.algamoney.api.repository;

import java.util.Optional;

import com.example.algamoney.api.model.Usuario;
import com.example.algamoney.api.repository.usuario.UsuarioRepositoryQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryQuery {
    public Optional<Usuario> findByEmail(String email);
}
