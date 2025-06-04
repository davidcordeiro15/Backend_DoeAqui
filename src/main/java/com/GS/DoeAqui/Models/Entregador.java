package com.GS.DoeAqui.Models;

/**
 * Representa um entregador que estende a classe Perfil, com informações sobre tipo de veículo e rota de entrega.
 */
public class Entregador extends Perfil {

    /**
     * Tipo do veículo utilizado pelo entregador.
     */
    private String tipoVeiculo;

    /**
     * Rota de entrega atribuída ao entregador.
     */
    private String rotaDeEntrega;

    /**
     * Retorna o tipo do veículo do entregador.
     *
     * @return tipo do veículo
     */
    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    /**
     * Define o tipo do veículo do entregador.
     *
     * @param tipoVeiculo tipo do veículo a ser definido
     */
    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    /**
     * Retorna a rota de entrega do entregador.
     *
     * @return rota de entrega
     */

    public String getRotaDeEntrega() {
        return rotaDeEntrega;
    }

    /**
     * Define a rota de entrega do entregador.
     *
     * @param rotaDeEntrega rota de entrega a ser definida
     */

    public void setRotaDeEntrega(String rotaDeEntrega) {
        this.rotaDeEntrega = rotaDeEntrega;
    }
}