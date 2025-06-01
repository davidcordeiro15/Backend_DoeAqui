package com.GS.DoeAqui.Repositories;

import com.GS.DoeAqui.DTOs.RotaDTO;
import com.GS.DoeAqui.Models.Rota;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Repositório para gerenciar objetos do tipo Rota em memória.
 */
@Repository
public class RotaRepository {

    /** Lista interna para armazenamento das rotas */
    private final List<Rota> rotas = new ArrayList<>();

    /** Gerador automático para o código de acompanhamento das rotas */
    private final AtomicInteger codigoGenerator = new AtomicInteger(1);

    /**
     * Adiciona uma nova rota e gera automaticamente seu código de acompanhamento.
     * @param rota objeto Rota a ser adicionado
     */
    public void adicionar(Rota rota) {
        rota.setCodigoAcompanhamento(codigoGenerator.getAndIncrement());
        rotas.add(rota);
    }

    /**
     * Busca uma rota pelo código de acompanhamento.
     * @param codigo código de acompanhamento da rota
     * @return Optional contendo a rota encontrada ou vazio se não existir
     */
    public Optional<Rota> buscarPorCodigo(int codigo) {
        return rotas.stream()
                .filter(r -> r.getCodigoAcompanhamento() == codigo)
                .findFirst();
    }

    /**
     * Lista todas as rotas armazenadas.
     * @return lista de rotas
     */
    public List<Rota> listarTodas() {
        return new ArrayList<>(rotas);
    }

    /**
     * Atualiza os dados de uma rota identificada pelo código.
     * @param codigo código de acompanhamento da rota
     * @param dto dados atualizados da rota
     * @return true se a rota foi atualizada, false caso não seja encontrada
     */
    public boolean atualizar(int codigo, RotaDTO dto) {
        Optional<Rota> optionalRota = buscarPorCodigo(codigo);
        if (optionalRota.isPresent()) {
            Rota rota = optionalRota.get();
            rota.setOrigem(dto.getOrigem());
            rota.setDestino(dto.getDestino());
            rota.setStatus(dto.getStatus());
            rota.setRotaDeEntrega(dto.getRotaDeEntrega());
            rota.setEntregadorResponsavel(dto.getEntregadorResponsavel());
            // Atualização da listaDeDoacoes pode ser implementada aqui se necessário
            return true;
        }
        return false;
    }

    /**
     * Remove uma rota pelo código de acompanhamento.
     * @param codigo código de acompanhamento da rota a ser removida
     * @return true se a rota foi removida, false caso não seja encontrada
     */
    public boolean remover(int codigo) {
        return rotas.removeIf(r -> r.getCodigoAcompanhamento() == codigo);
    }
}
