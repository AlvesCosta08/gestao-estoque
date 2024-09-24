package com.gestao_estoque.gestao_estoque.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Tb_Produto", indexes = {
        @Index(name = "idx_referencia", columnList = "referencia"),
        @Index(name = "idx_descricao", columnList = "descricao")
})
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;

    @Column(nullable = false, length = 100)
    private String referencia;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "unid_medida", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidMedida;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precoUnitario;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "foto_produto", length = 255)
    private String fotoProduto;

    @Column(name = "qr_code", length = 255)
    private String qrCode;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Column(name = "criado_em", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime atualizadoEm;

    public Produto() {
    }

    public Produto(Long id_produto, String referencia, String descricao, UnidadeMedida unidMedida, BigDecimal precoUnitario, Integer quantidade, String fotoProduto, String qrCode, Categoria categoria, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.id_produto = id_produto;
        this.referencia = referencia;
        this.descricao = descricao;
        this.unidMedida = unidMedida;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.fotoProduto = fotoProduto;
        this.qrCode = qrCode;
        this.categoria = categoria;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UnidadeMedida getUnidMedida() {
        return unidMedida;
    }

    public void setUnidMedida(UnidadeMedida unidMedida) {
        this.unidMedida = unidMedida;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getFotoProduto() {
        return fotoProduto;
    }

    public void setFotoProduto(String fotoProduto) {
        this.fotoProduto = fotoProduto;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id_produto, produto.id_produto) && Objects.equals(referencia, produto.referencia) && Objects.equals(descricao, produto.descricao) && unidMedida == produto.unidMedida && Objects.equals(precoUnitario, produto.precoUnitario) && Objects.equals(quantidade, produto.quantidade) && Objects.equals(fotoProduto, produto.fotoProduto) && Objects.equals(qrCode, produto.qrCode) && Objects.equals(categoria, produto.categoria) && Objects.equals(criadoEm, produto.criadoEm) && Objects.equals(atualizadoEm, produto.atualizadoEm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_produto, referencia, descricao, unidMedida, precoUnitario, quantidade, fotoProduto, qrCode, categoria, criadoEm, atualizadoEm);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id_produto=" + id_produto +
                ", referencia='" + referencia + '\'' +
                ", descricao='" + descricao + '\'' +
                ", unidMedida=" + unidMedida +
                ", precoUnitario=" + precoUnitario +
                ", quantidade=" + quantidade +
                ", fotoProduto='" + fotoProduto + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", categoria=" + categoria +
                ", criadoEm=" + criadoEm +
                ", atualizadoEm=" + atualizadoEm +
                '}';
    }
}

enum UnidadeMedida {
    PC, PCO10X, PCO100X, CX100X, CX50X
}
