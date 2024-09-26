package com.gestao_estoque.gestao_estoque.controllers;

import com.gestao_estoque.gestao_estoque.models.Estoque;
import com.gestao_estoque.gestao_estoque.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<Estoque> criarEstoque(@RequestBody Estoque estoque) {
        Estoque novoEstoque = estoqueService.criarEstoque(estoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEstoque);
    }

    @GetMapping
    public ResponseEntity<List<Estoque>> listarEstoques() {
        List<Estoque> estoques = estoqueService.listarEstoques();
        return ResponseEntity.ok(estoques);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> buscarEstoquePorId(@PathVariable Long id) {
        Optional<Estoque> estoque = estoqueService.buscarEstoquePorId(id);
        return estoque.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estoque> atualizarEstoque(@PathVariable Long id, @RequestBody Estoque estoqueAtualizado) {
        Estoque estoque = estoqueService.atualizarEstoque(id, estoqueAtualizado);
        return ResponseEntity.ok(estoque);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstoque(@PathVariable Long id) {
        estoqueService.deletarEstoque(id);
        return ResponseEntity.noContent().build();
    }
}
