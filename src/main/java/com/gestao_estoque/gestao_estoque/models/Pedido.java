package com.gestao_estoque.gestao_estoque.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Tb_Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(nullable = false, length = 100)
    private String referencia;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricaoItem;

    @Column(name = "unid_medida", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidMedida;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double valorUnitario;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double subTotal;

    @Column(name = "forma_pagamento", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double total;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private StatusPedido status = StatusPedido.PENDENTE;

    @Column(name = "criado_em", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime atualizadoEm;

    public Pedido() {
    }

    public Pedido(Long id_pedido, Cliente cliente, String referencia, Integer quantidade, String descricaoItem, UnidadeMedida unidMedida, Double valorUnitario, Double subTotal, FormaPagamento formaPagamento, Double total, StatusPedido status, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.id_pedido = id_pedido;
        this.cliente = cliente;
        this.referencia = referencia;
        this.quantidade = quantidade;
        this.descricaoItem = descricaoItem;
        this.unidMedida = unidMedida;
        this.valorUnitario = valorUnitario;
        this.subTotal = subTotal;
        this.formaPagamento = formaPagamento;
        this.total = total;
        this.status = status;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id_pedido, pedido.id_pedido) && Objects.equals(cliente, pedido.cliente) && Objects.equals(referencia, pedido.referencia) && Objects.equals(quantidade, pedido.quantidade) && Objects.equals(descricaoItem, pedido.descricaoItem) && unidMedida == pedido.unidMedida && Objects.equals(valorUnitario, pedido.valorUnitario) && Objects.equals(subTotal, pedido.subTotal) && formaPagamento == pedido.formaPagamento && Objects.equals(total, pedido.total) && status == pedido.status && Objects.equals(criadoEm, pedido.criadoEm) && Objects.equals(atualizadoEm, pedido.atualizadoEm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pedido, cliente, referencia, quantidade, descricaoItem, unidMedida, valorUnitario, subTotal, formaPagamento, total, status, criadoEm, atualizadoEm);
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public UnidadeMedida getUnidMedida() {
        return unidMedida;
    }

    public void setUnidMedida(UnidadeMedida unidMedida) {
        this.unidMedida = unidMedida;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido=" + id_pedido +
                ", cliente=" + cliente +
                ", referencia='" + referencia + '\'' +
                ", quantidade=" + quantidade +
                ", descricaoItem='" + descricaoItem + '\'' +
                ", unidMedida=" + unidMedida +
                ", valorUnitario=" + valorUnitario +
                ", subTotal=" + subTotal +
                ", formaPagamento=" + formaPagamento +
                ", total=" + total +
                ", status=" + status +
                ", criadoEm=" + criadoEm +
                ", atualizadoEm=" + atualizadoEm +
                '}';
    }
}

enum FormaPagamento {
    CARTAO, DINHEIRO, TRANSFERENCIA, BOLETO
}

enum StatusPedido {
    PENDENTE, CONCLUIDO, CANCELADO
}
