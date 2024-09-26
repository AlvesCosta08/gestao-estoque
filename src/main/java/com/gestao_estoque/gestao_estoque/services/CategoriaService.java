package com.gestao_estoque.gestao_estoque.services;

import com.gestao_estoque.gestao_estoque.models.Categoria;
import com.gestao_estoque.gestao_estoque.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(Categoria categoria) {
        categoria.setCriadoEm(LocalDateTime.now());
        categoria.setAtualizadoEm(LocalDateTime.now()); // Inicializa a data de atualização
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria atualizarCategoria(Long id, Categoria categoriaAtualizada) {
        categoriaAtualizada.setId_categoria(id); // Supondo que você tenha um setter para o ID
        categoriaAtualizada.setAtualizadoEm(LocalDateTime.now());
        return categoriaRepository.save(categoriaAtualizada);
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
