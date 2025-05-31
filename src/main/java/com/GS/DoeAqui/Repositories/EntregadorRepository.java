package com.GS.DoeAqui.Repositories;

import com.GS.DoeAqui.Models.Entregador;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntregadorRepository{

    private final List<Entregador> entregadores = new ArrayList<>();

    public EntregadorRepository() {
        entregadores.add(new Entregador("joao", "123"));
        entregadores.add(new Entregador("maria", "senha123"));
    }

    public List<Entregador> findAll() {
        return entregadores;
    }
}
