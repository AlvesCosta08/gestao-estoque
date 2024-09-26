package com.gestao_estoque.gestao_estoque.services;

import com.gestao_estoque.gestao_estoque.models.Pedido;
import com.gestao_estoque.gestao_estoque.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido) {
        pedido.setCriadoEm(LocalDateTime.now());
        pedido.setAtualizadoEm(LocalDateTime.now()); // Inicializa a data de atualização
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        pedidoAtualizado.setId_pedido(id); // Supondo que você tenha um setter para o ID
        pedidoAtualizado.setAtualizadoEm(LocalDateTime.now());
        return pedidoRepository.save(pedidoAtualizado);
    }

    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
