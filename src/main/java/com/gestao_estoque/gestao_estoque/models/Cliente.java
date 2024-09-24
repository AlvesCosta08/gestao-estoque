package com.gestao_estoque.gestao_estoque.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Tb_Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(length = 150)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String endereco;

    @Column(length = 20)
    private String cep;

    @Column(length = 100)
    private String cidade;

    @Column(length = 2)
    private String uf;

    @Column(length = 20)
    private String telefone;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;

    @Column(length = 14, unique = true)
    private String cpf;

    @Column(length = 18, unique = true)
    private String cnpj;

    @Column(length = 255)
    private String nomeFantasia;

    @Column(length = 255)
    private String razaoSocial;

    @Column(length = 50)
    private String inscricaoEstadual;

    @Column(name = "criado_em", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime atualizadoEm;

    public Cliente() {
    }

    public Cliente(Long id_cliente, String nome, String email, String endereco, String cep, String cidade, String uf, String telefone, TipoCliente tipo, String cpf, String cnpj, String nomeFantasia, String razaoSocial, String inscricaoEstadual, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.tipo = tipo;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
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
        Cliente cliente = (Cliente) o;
        return Objects.equals(id_cliente, cliente.id_cliente) && Objects.equals(nome, cliente.nome) && Objects.equals(email, cliente.email) && Objects.equals(endereco, cliente.endereco) && Objects.equals(cep, cliente.cep) && Objects.equals(cidade, cliente.cidade) && Objects.equals(uf, cliente.uf) && Objects.equals(telefone, cliente.telefone) && tipo == cliente.tipo && Objects.equals(cpf, cliente.cpf) && Objects.equals(cnpj, cliente.cnpj) && Objects.equals(nomeFantasia, cliente.nomeFantasia) && Objects.equals(razaoSocial, cliente.razaoSocial) && Objects.equals(inscricaoEstadual, cliente.inscricaoEstadual) && Objects.equals(criadoEm, cliente.criadoEm) && Objects.equals(atualizadoEm, cliente.atualizadoEm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_cliente, nome, email, endereco, cep, cidade, uf, telefone, tipo, cpf, cnpj, nomeFantasia, razaoSocial, inscricaoEstadual, criadoEm, atualizadoEm);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", tipo=" + tipo +
                ", cpf='" + cpf + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", inscricaoEstadual='" + inscricaoEstadual + '\'' +
                ", criadoEm=" + criadoEm +
                ", atualizadoEm=" + atualizadoEm +
                '}';
    }
}

enum TipoCliente {
    PESSOA_FISICA, PESSOA_JURIDICA
}
