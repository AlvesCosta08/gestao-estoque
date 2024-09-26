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
        // Verifica se o usuário existe antes de atualizar
        Optional<Usuario> usuarioExistenteOpt = usuarioRepository.findById(id);
        if (usuarioExistenteOpt.isPresent()) {
            Usuario usuarioExistente = usuarioExistenteOpt.get();
            usuarioAtualizado.setId_usuario(usuarioExistente.getId_usuario()); // Preserva o ID existente
            usuarioAtualizado.setAtualizadoEm(LocalDateTime.now());
            return usuarioRepository.save(usuarioAtualizado);
        } else {
            throw new RuntimeException("Usuário não encontrado para o ID: " + id); // Exceção personalizada
        }
    }

    public void deletarUsuario(Long id) {
        // Verifica se o usuário existe antes de deletar
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado para o ID: " + id); // Exceção personalizada
        }
    }

    // Método para buscar usuário por email
    public Optional<Usuario> buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}

