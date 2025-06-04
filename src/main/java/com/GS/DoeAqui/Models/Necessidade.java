package com.GS.DoeAqui.Models;


import jakarta.persistence.Entity;

import java.util.List;

/**
 * Classe que representa uma necessidade de um donatário.
 */
@Entity
public class Necessidade {
    private int id;
    private int idDonatario;
    private List<String> listaDeItens;
    private int quantidadeDePessoasAfetadas; // Número que estima qual a quantidade das doações será realocada ao local
    private String localDeEntrega;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDonatario() {
        return idDonatario;
    }

    public void setIdDonatario(int idDonatário) {
        this.idDonatario = idDonatário;
    }

    public List<String> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(List<String> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    public int getQuantidadeaDePessoasAfetadas() {
        return quantidadeDePessoasAfetadas;
    }

    public void setQuantidadeaDePessoasAfetadas(int quantidadeaDePessoasAfetadas) {
        this.quantidadeDePessoasAfetadas = quantidadeaDePessoasAfetadas;
    }

    public String getLocalDeEntrega() {
        return localDeEntrega;
    }

    public void setLocalDeEntrega(String localDeEntrega) {
        this.localDeEntrega = localDeEntrega;
    }
}
