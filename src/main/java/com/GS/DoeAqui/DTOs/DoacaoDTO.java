package com.GS.DoeAqui.DTOs;

/**
 * Data Transfer Object para criação e atualização de Doação.
 */
public class DoacaoDTO {

    /** ID do Perfil que é doador */
    private int doadorId;

    /** Tipo da doação */
    private String tipoDoacao;

    /** Local de origem da doação */
    private String origem;

    /** Local de destino da doação */
    private String destino;

    /**
     * Retorna o ID do doador.
     * @return ID do perfil do doador
     */
    public int getDoadorId() {
        return doadorId;
    }

    /**
     * Define o ID do doador.
     * @param doadorId ID do perfil do doador
     */
    public void setDoadorId(int doadorId) {
        this.doadorId = doadorId;
    }

    /**
     * Retorna o tipo da doação.
     * @return tipo da doação
     */
    public String getTipoDoacao() {
        return tipoDoacao;
    }

    /**
     * Define o tipo da doação.
     * @param tipoDoacao tipo da doação
     */
    public void setTipoDoacao(String tipoDoacao) {
        this.tipoDoacao = tipoDoacao;
    }

    /**
     * Retorna a origem da doação.
     * @return local de origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * Define a origem da doação.
     * @param origem local de origem
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     * Retorna o destino da doação.
     * @return local de destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Define o destino da doação.
     * @param destino local de destino
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }
}
