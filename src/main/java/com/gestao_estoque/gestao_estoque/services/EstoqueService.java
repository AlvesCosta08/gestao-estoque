package com.gestao_estoque.gestao_estoque.services;

import com.gestao_estoque.gestao_estoque.models.Estoque;
import com.gestao_estoque.gestao_estoque.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public Estoque criarEstoque(Estoque estoque) {
        estoque.setDataAtualizacao(LocalDateTime.now());
        return estoqueRepository.save(estoque);
    }

    public List<Estoque> listarEstoques() {
        return estoqueRepository.findAll();
    }

    public Optional<Estoque> buscarEstoquePorId(Long id) {
        return estoqueRepository.findById(id);
    }

    public Estoque atualizarEstoque(Long id, Estoque estoqueAtualizado) {
        estoqueAtualizado.setId_estoque(id); // Atualiza o ID do estoque
        estoqueAtualizado.setDataAtualizacao(LocalDateTime.now());
        return estoqueRepository.save(estoqueAtualizado);
    }

    public void deletarEstoque(Long id) {
        estoqueRepository.deleteById(id);
    }
}
