package com.GS.DoeAqui.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

/**
 * Representa uma rota para entrega.
 */
@Entity
public class Rota {

    /** Código único de acompanhamento da rota */
    @Id
    private int codigoAcompanhamento;

    /** Origem da rota */
    private String origem;

    /** Destino da rota */
    private String destino;

    /** Status atual da rota */
    private String status;

    /** Descrição da rota de entrega */
    private String rotaDeEntrega;

    /** Nome do entregador responsável */
    private String entregadorResponsavel;

    /** Lista de IDs das doações vinculadas à rota */
    private List<Integer> listaDeDoacoes;

    public Rota() {}

    /** Getters e setters */

    public int getCodigoAcompanhamento() {
        return codigoAcompanhamento;
    }

    public void setCodigoAcompanhamento(int codigoAcompanhamento) {
        this.codigoAcompanhamento = codigoAcompanhamento;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRotaDeEntrega() {
        return rotaDeEntrega;
    }

    public void setRotaDeEntrega(String rotaDeEntrega) {
        this.rotaDeEntrega = rotaDeEntrega;
    }

    public String getEntregadorResponsavel() {
        return entregadorResponsavel;
    }

    public void setEntregadorResponsavel(String entregadorResponsavel) {
        this.entregadorResponsavel = entregadorResponsavel;
    }

    public List<Integer> getListaDeDoacoes() {
        return listaDeDoacoes;
    }

    public void setListaDeDoacoes(List<Integer> listaDeDoacoes) {
        this.listaDeDoacoes = listaDeDoacoes;
    }
}
