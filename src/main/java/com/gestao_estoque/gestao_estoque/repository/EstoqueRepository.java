package com.gestao_estoque.gestao_estoque.repository;

import com.gestao_estoque.gestao_estoque.models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque,Long> {
}
