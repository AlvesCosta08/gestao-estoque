package com.gestao_estoque.gestao_estoque.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_estoque.gestao_estoque.models.Usuario;
import com.gestao_estoque.gestao_estoque.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setCriadoEm(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        usuarioAtualizado.setId_usuario(id); // Supondo que você tenha um setter para o ID
        usuarioAtualizado.setAtualizadoEm(LocalDateTime.now());
        return usuarioRepository.save(usuarioAtualizado);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
