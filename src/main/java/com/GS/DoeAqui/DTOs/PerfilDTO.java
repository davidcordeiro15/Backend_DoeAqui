package com.GS.DoeAqui.DTOs;

import com.GS.DoeAqui.Models.Perfil;

/**
 * Data Transfer Object para recebimento e envio de dados do Perfil.
 * Usado para criar ou atualizar perfis.
 */
public class PerfilDTO {

    private int id;
    private String login;
    private String senha;
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private String necessidade;
    private String nomeONG;
    private String rotaDeEntrega;
    private String tipoVeiculo;
    private String tipoPerfil;

    public PerfilDTO() {}

    /**
     * Construtor para criar DTO a partir de um Perfil.
     * @param perfil objeto Perfil
     */
    public PerfilDTO(Perfil perfil) {
        this.id = perfil.getId();
        this.login = perfil.getLogin();
        this.senha = perfil.getSenha();
        this.nome = perfil.getNome();
        this.endereco = perfil.getEndereco();
        this.cidade = perfil.getCidade();
        this.estado = perfil.getEstado();
        this.necessidade = perfil.getNecessidade();
        this.nomeONG = perfil.getNomeONG();
        this.rotaDeEntrega = perfil.getRotaDeEntrega();
        this.tipoVeiculo = perfil.getTipoVeiculo();
        this.tipoPerfil = perfil.getTipoPerfil();
    }

    /** Getters e setters */

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getNecessidade() {
        return necessidade;
    }
    public void setNecessidade(String necessidade) {
        this.necessidade = necessidade;
    }
    public String getNomeONG() {
        return nomeONG;
    }
    public void setNomeONG(String nomeONG) {
        this.nomeONG = nomeONG;
    }
    public String getRotaDeEntrega() {
        return rotaDeEntrega;
    }
    public void setRotaDeEntrega(String rotaDeEntrega) {
        this.rotaDeEntrega = rotaDeEntrega;
    }
    public String getTipoVeiculo() {
        return tipoVeiculo;
    }
    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
    public String getTipoPerfil() {
        return tipoPerfil;
    }
    public void setTipoPerfil(String tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    /**
     * Converte o DTO para um objeto Perfil.
     * @return Perfil populado com os dados do DTO
     */
    public Perfil toPerfil() {
        Perfil perfil = new Perfil();
        perfil.setId(this.id);
        perfil.setLogin(this.login);
        perfil.setSenha(this.senha);
        perfil.setNome(this.nome);
        perfil.setEndereco(this.endereco);
        perfil.setCidade(this.cidade);
        perfil.setEstado(this.estado);
        perfil.setNecessidade(this.necessidade);
        perfil.setNomeONG(this.nomeONG);
        perfil.setRotaDeEntrega(this.rotaDeEntrega);
        perfil.setTipoVeiculo(this.tipoVeiculo);
        perfil.setTipoPerfil(this.tipoPerfil);
        return perfil;
    }
}
