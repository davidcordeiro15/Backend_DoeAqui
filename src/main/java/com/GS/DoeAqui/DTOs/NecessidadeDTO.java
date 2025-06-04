package com.GS.DoeAqui.DTOs;

import java.util.List;

/**
 * DTO para transferir dados da classe Necessidade.
 */
public class NecessidadeDTO {

    private int idDonatario;
    private List<String> listaDeItens;
    private int quantidadeaDePessoasAfetadas;
    private String localDeEntrega;

    public int getIdDonatario() {
        return idDonatario;
    }

    public void setIdDonatario(int idDonatario) {
        this.idDonatario = idDonatario;
    }

    public List<String> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(List<String> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    public int getQuantidadeaDePessoasAfetadas() {
        return quantidadeaDePessoasAfetadas;
    }

    public void setQuantidadeaDePessoasAfetadas(int quantidadeaDePessoasAfetadas) {
        this.quantidadeaDePessoasAfetadas = quantidadeaDePessoasAfetadas;
    }

    public String getLocalDeEntrega() {
        return localDeEntrega;
    }

    public void setLocalDeEntrega(String localDeEntrega) {
        this.localDeEntrega = localDeEntrega;
    }
}
