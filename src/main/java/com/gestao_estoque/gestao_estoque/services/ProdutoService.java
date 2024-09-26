package com.gestao_estoque.gestao_estoque.services;

import com.gestao_estoque.gestao_estoque.models.Produto;
import com.gestao_estoque.gestao_estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto) {
        produto.setCriadoEm(LocalDateTime.now());
        produto.setAtualizadoEm(LocalDateTime.now()); // Inicializa a data de atualização
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        produtoAtualizado.setId_produto(id); // Supondo que você tenha um setter para o ID
        produtoAtualizado.setAtualizadoEm(LocalDateTime.now());
        return produtoRepository.save(produtoAtualizado);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
