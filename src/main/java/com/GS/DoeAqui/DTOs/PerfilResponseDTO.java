package com.GS.DoeAqui.DTOs;

import com.GS.DoeAqui.Models.Perfil;

/**
 * Data Transfer Object para enviar dados de Perfil em respostas HTTP.
 * Contém apenas informações que não comprometem a segurança (exclui senha e login).
 */
public class PerfilResponseDTO {

    private int id;
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private String necessidade;
    private String nomeONG;
    private String rotaDeEntrega;
    private String tipoVeiculo;


    /**
     * Constrói o DTO de resposta a partir do Perfil.
     * @param perfil objeto Perfil
     */
    public PerfilResponseDTO(Perfil perfil) {
        this.id = perfil.getId();
        this.nome = perfil.getNome();
        this.endereco = perfil.getEndereco();
        this.cidade = perfil.getCidade();
        this.estado = perfil.getEstado();

    }

    /** Getters */

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public String getNecessidade() {
        return necessidade;
    }
    public String getNomeONG() {
        return nomeONG;
    }
    public String getRotaDeEntrega() {
        return rotaDeEntrega;
    }
    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

}
