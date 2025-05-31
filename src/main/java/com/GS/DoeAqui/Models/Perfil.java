package com.GS.DoeAqui.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String login;
    private String senha;
    private String cidade;
    private String estado;

    public Perfil(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }


    public String getLogin(){
        return login;
    }

    public String getSenha(){
        return senha;
    }

}
