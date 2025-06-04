package com.GS.DoeAqui.Models;

import java.util.List;


/**
 * Representa um donatário, que contém uma lista de necessidades e o nome da ONG associada.
 */
public class Donatario extends Perfil{
    /**
     * Lista de necessidades do donatário.
     */
    private List<Necessidade> necessidade;

    /**
     * Nome da ONG associada ao donatário.
     */
    private String nomeONG;

    /**
     * Retorna a lista de necessidades do donatário.
     *
     * @return lista de necessidades
     */
    public List<Necessidade> getNecessidade() {
        return necessidade;
    }

    /**
     * Define a lista de necessidades do donatário.
     *
     * @param necessidade lista de necessidades a ser atribuída
     */
    public void setNecessidade(List<Necessidade> necessidade) {
        this.necessidade = necessidade;
    }

    /**
     * Retorna o nome da ONG associada ao donatário.
     *
     * @return nome da ONG
     */
    public String getNomeONG() {
        return nomeONG;
    }

    /**
     * Define o nome da ONG associada ao donatário.
     *
     * @param nomeONG nome da ONG a ser atribuído
     */
    public void setNomeONG(String nomeONG) {
        this.nomeONG = nomeONG;
    }
}