package com.gestao_estoque.gestao_estoque.services;

import com.gestao_estoque.gestao_estoque.models.Cliente;
import com.gestao_estoque.gestao_estoque.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente) {
        cliente.setCriadoEm(LocalDateTime.now());
        cliente.setAtualizadoEm(LocalDateTime.now()); // Inicializa a data de atualização
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        clienteAtualizado.setId_cliente(id); // Supondo que você tenha um setter para o ID
        clienteAtualizado.setAtualizadoEm(LocalDateTime.now());
        return clienteRepository.save(clienteAtualizado);
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
