package com.GS.DoeAqui.Models.Donatario;

import com.GS.DoeAqui.Models.Perfil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Donatario extends Perfil {
    private String tipoNecessidade;
    private String NomeONG;

    public Donatario(String login, String senha) {
        super(login, senha);
    }
}
