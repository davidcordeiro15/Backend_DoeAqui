package com.GS.DoeAqui.Models;

import com.GS.DoeAqui.Models.Doacao.Doacao;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class Rota {
    private List<Doacao> listaDeDoacoes;
    private String rotaDeEntrega;
    private String EntregadorResponsavel;
    private int codigoAcompanhamento;

    public int getCodigoAcompanhamento() {
        return codigoAcompanhamento;
    }

    public void setCodigoAcompanhamento(int codigoAcompanhamento) {
        this.codigoAcompanhamento = codigoAcompanhamento;
    }

    public List<Doacao> getListaDeDoacoes() {
        return listaDeDoacoes;
    }

    public void setListaDeDoacoes(List<Doacao> listaDeDoacoes) {
        this.listaDeDoacoes = listaDeDoacoes;
    }

    public String getRotaDeEntrega() {
        return rotaDeEntrega;
    }

    public void setRotaDeEntrega(String rotaDeEntrega) {
        this.rotaDeEntrega = rotaDeEntrega;
    }

    public String getEntregadorResponsavel() {
        return EntregadorResponsavel;
    }

    public void setEntregadorResponsavel(String entregadorResponsavel) {
        EntregadorResponsavel = entregadorResponsavel;
    }
}
