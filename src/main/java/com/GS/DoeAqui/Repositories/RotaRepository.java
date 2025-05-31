package com.GS.DoeAqui.Repositories;

import com.GS.DoeAqui.Models.Rota;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RotaRepository {

    private final List<Rota> rotas = new ArrayList<>();
    private int proximoCodigo = 0;

    public RotaRepository() {
        Rota rota1 = new Rota();
        rota1.setCodigoAcompanhamento(1);
        rota1.setRotaDeEntrega("Zona Norte");
        rota1.setEntregadorResponsavel("João da Silva");

        Rota rota2 = new Rota();
        rota2.setCodigoAcompanhamento(2);
        rota2.setRotaDeEntrega("Centro");
        rota2.setEntregadorResponsavel("Maria Oliveira");

        Rota rota3 = new Rota();
        rota3.setCodigoAcompanhamento(3);
        rota3.setRotaDeEntrega("Zona Sul");
        rota3.setEntregadorResponsavel("Carlos Souza");

        rotas.add(rota1);
        rotas.add(rota2);
        rotas.add(rota3);
    }

    // Salvar rota
    public Rota salvar(Rota rota) {
        rota.setCodigoAcompanhamento(proximoCodigo++);
        rotas.add(rota);
        return rota;
    }

    // Buscar por código
    public Optional<Rota> buscarPorCodigo(int codigo) {
        return rotas.stream()
                .filter(r -> r.getCodigoAcompanhamento() == codigo)
                .findFirst();
    }

    // Listar todas
    public List<Rota> listarTodas() {
        return new ArrayList<>(rotas);
    }

    // Remover por código
    public boolean removerPorCodigo(int codigo) {
        return rotas.removeIf(r -> r.getCodigoAcompanhamento() == codigo);
    }

    // Limpar repositório (opcional para testes)
    public void limpar() {
        rotas.clear();
        proximoCodigo = 1;
    }
}
