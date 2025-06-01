package com.GS.DoeAqui.DTOs;

import java.util.List;

/**
 * Data Transfer Object para informações de uma rota.
 */
public class RotaDTO {

    /** Lista de IDs das doações associadas à rota */
    private List<Integer> listaDeDoacoes;

    /** Nome ou descrição da rota de entrega */
    private String rotaDeEntrega;

    /** Nome do entregador responsável pela rota */
    private String entregadorResponsavel;

    /** Local de origem da rota */
    private String origem;

    /** Local de destino da rota */
    private String destino;

    /** Status atual da rota */
    private String status;

    /** Construtor padrão */
    public RotaDTO() {}

    // Getters e setters com documentação

    /**
     * Obtém a lista de IDs das doações.
     * @return lista de IDs das doações
     */
    public List<Integer> getListaDeDoacoes() {
        return listaDeDoacoes;
    }

    /**
     * Define a lista de IDs das doações.
     * @param listaDeDoacoes lista de IDs das doações
     */
    public void setListaDeDoacoes(List<Integer> listaDeDoacoes) {
        this.listaDeDoacoes = listaDeDoacoes;
    }

    /**
     * Obtém a descrição da rota de entrega.
     * @return descrição da rota de entrega
     */
    public String getRotaDeEntrega() {
        return rotaDeEntrega;
    }

    /**
     * Define a descrição da rota de entrega.
     * @param rotaDeEntrega descrição da rota de entrega
     */
    public void setRotaDeEntrega(String rotaDeEntrega) {
        this.rotaDeEntrega = rotaDeEntrega;
    }

    /**
     * Obtém o nome do entregador responsável.
     * @return nome do entregador responsável
     */
    public String getEntregadorResponsavel() {
        return entregadorResponsavel;
    }

    /**
     * Define o nome do entregador responsável.
     * @param entregadorResponsavel nome do entregador responsável
     */
    public void setEntregadorResponsavel(String entregadorResponsavel) {
        this.entregadorResponsavel = entregadorResponsavel;
    }

    /**
     * Obtém o local de origem da rota.
     * @return local de origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * Define o local de origem da rota.
     * @param origem local de origem
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     * Obtém o local de destino da rota.
     * @return local de destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Define o local de destino da rota.
     * @param destino local de destino
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Obtém o status atual da rota.
     * @return status da rota
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status atual da rota.
     * @param status status da rota
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
