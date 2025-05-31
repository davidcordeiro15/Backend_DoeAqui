package com.GS.DoeAqui.Models.Doacao;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Doacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String tipoDoacao;
    private String origem;
    private String destino;
}
