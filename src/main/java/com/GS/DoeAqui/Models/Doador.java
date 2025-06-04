package com.GS.DoeAqui.Models;

/**
 * Representa um doador que estende a classe Perfil, contendo informações sobre a doação e seu tipo.
 */
public class Doador extends Perfil {

    /**
     * Doação realizada pelo doador.
     */
    private Doacao doacao;

    /**
     * Tipo da doação realizada.
     */
    private String tipoDoacao;

    /**
     * Retorna a doação realizada pelo doador.
     *
     * @return doação
     */
    public Doacao getDoacao() {
        return doacao;
    }

    /**
     * Define a doação realizada pelo doador.
     *
     * @param doacao doação a ser atribuída
     */
    public void setDoacao(Doacao doacao) {
        this.doacao = doacao;
    }

    /**
     * Retorna o tipo da doação.
     *
     * @return tipo da doação
     */
    public String getTipoDoacao() {
        return tipoDoacao;
    }

    /**
     * Define o tipo da doação.
     *
     * @param tipoDoacao tipo da doação a ser definido
     */
    public void setTipoDoacao(String tipoDoacao) {
        this.tipoDoacao = tipoDoacao;
    }
}
