package com.GS.DoeAqui.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Entregador extends Perfil {
    private String rotaDeEntrega;
    private String tipoVeiculo;


    public Entregador(String login, String senha){
        super(login, senha);
    }



}
