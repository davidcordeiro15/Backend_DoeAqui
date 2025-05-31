package com.GS.DoeAqui.Models.Doador;

import com.GS.DoeAqui.Models.Perfil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Doador extends Perfil {
    private String doacao;
    private String tipoDoacao;

    public Doador(String login, String senha) {
        super(login, senha);
    }
}
