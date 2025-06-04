package com.GS.DoeAqui.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Representa o perfil do usuário no sistema.
 * Pode conter dados de login, endereço e informações específicas como necessidades e rota de entrega.
 */
@EqualsAndHashCode(of = "id")
@Entity
public class Perfil {

    /** Identificador único do perfil */
    @Id
    private int id;

    /** Nome do usuário */
    private String nome;

    /** Endereço do usuário */
    private String endereco;

    /** Login para autenticação */
    private String login;

    /** Senha para autenticação */
    private String senha;

    /** Cidade do usuário */
    private String cidade;

    /** Estado do usuário */
    private String estado;

    /** Lista de doações associadas ao perfil */
    private List<Doacao> doacoes;

    /** Necessidades específicas do perfil (ex: ONG) */
    private String necessidade;

    /** Nome da ONG, se aplicável */
    private String nomeONG;

    /** Rota de entrega associada ao perfil */
    private String rotaDeEntrega;

    /** Tipo de veículo associado ao perfil */
    private String tipoVeiculo;

    /** Tipo do perfil (ex: entregador, ONG, etc.) */
    private String tipoPerfil;

    /** Construtor padrão */
    public Perfil() {}

    /**
     * Construtor completo.
     * @param id identificador
     * @param login login do usuário
     * @param senha senha do usuário
     * @param nome nome do usuário
     * @param endereco endereço
     * @param cidade cidade
     * @param estado estado
     */
    public Perfil(int id, String login, String senha, String nome, String endereco, String cidade, String estado) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    /** Getters e setters */

    /**
     * Retorna o login do usuário.
     * Anotado com JsonIgnore para não ser serializado nas respostas JSON.
     * @return login do usuário
     */
    @JsonIgnore
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Retorna a senha do usuário.
     * Anotado com JsonIgnore para não ser serializado nas respostas JSON.
     * @return senha do usuário
     */
    @JsonIgnore
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Doacao> getDoacoes() {
        return doacoes;
    }


}
