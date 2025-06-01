package com.GS.DoeAqui.DTOs;

import com.GS.DoeAqui.Models.Doacao;

/**
 * Data Transfer Object para resposta com os dados de Doação.
 */
public class DoacaoResponseDTO {

    private int codigo;
    private int doadorId;
    private String tipoDoacao;
    private String origem;
    private String destino;

    /**
     * Constrói o DTO a partir do objeto Doacao.
     * @param doacao objeto Doacao
     */
    public DoacaoResponseDTO(Doacao doacao) {
        this.codigo = doacao.getCodigo();
        this.doadorId = doacao.getDoador() != null ? doacao.getDoador().getId() : 0;
        this.tipoDoacao = doacao.getTipoDoacao();
        this.origem = doacao.getOrigem();
        this.destino = doacao.getDestino();
    }

    /**
     * Retorna o código da doação.
     * @return código da doação
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Retorna o ID do doador.
     * @return ID do perfil do doador
     */
    public int getDoadorId() {
        return doadorId;
    }

    /**
     * Retorna o tipo da doação.
     * @return tipo da doação
     */
    public String getTipoDoacao() {
        return tipoDoacao;
    }

    /**
     * Retorna a origem da doação.
     * @return local de origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * Retorna o destino da doação.
     * @return local de destino
     */
    public String getDestino() {
        return destino;
    }
}
