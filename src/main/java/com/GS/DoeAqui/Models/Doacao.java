package com.GS.DoeAqui.Models;

import jakarta.persistence.*;

/**
 * Representa uma doação realizada por um perfil.
 */
@Entity
public class Doacao {

    /** Código identificador único da doação */
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    /** Perfil do doador associado à doação */
    @ManyToOne
    private Perfil doador;

    /** Tipo da doação */
    private String tipoDoacao;

    /** Local de origem da doação */
    private String origem;

    /** Local de destino da doação */
    private String destino;

    /**
     * Retorna o código da doação.
     * @return código identificador
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Define o código da doação.
     * @param codigo código identificador
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o perfil do doador.
     * @return perfil do doador
     */
    public Perfil getDoador() {
        return doador;
    }

    /**
     * Define o perfil do doador.
     * @param doador perfil do doador
     */
    public void setDoador(Perfil doador) {
        this.doador = doador;
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
