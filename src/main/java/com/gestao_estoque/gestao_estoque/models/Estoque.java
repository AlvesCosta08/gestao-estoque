package com.gestao_estoque.gestao_estoque.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Tb_Estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estoque;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidadeAtual;

    @Column(nullable = false)
    private Integer quantidadeMinima;

    @Column(name = "data_atualizacao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataAtualizacao;

    public Estoque() {
    }

    public Estoque(Long id_estoque, Produto produto, Integer quantidadeAtual, Integer quantidadeMinima, LocalDateTime dataAtualizacao) {
        this.id_estoque = id_estoque;
        this.produto = produto;
        this.quantidadeAtual = quantidadeAtual;
        this.quantidadeMinima = quantidadeMinima;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId_estoque() {
        return id_estoque;
    }

    public void setId_estoque(Long id_estoque) {
        this.id_estoque = id_estoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(Integer quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public Integer getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Integer quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return Objects.equals(id_estoque, estoque.id_estoque) && Objects.equals(produto, estoque.produto) && Objects.equals(quantidadeAtual, estoque.quantidadeAtual) && Objects.equals(quantidadeMinima, estoque.quantidadeMinima) && Objects.equals(dataAtualizacao, estoque.dataAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_estoque, produto, quantidadeAtual, quantidadeMinima, dataAtualizacao);
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id_estoque=" + id_estoque +
                ", produto=" + produto +
                ", quantidadeAtual=" + quantidadeAtual +
                ", quantidadeMinima=" + quantidadeMinima +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
