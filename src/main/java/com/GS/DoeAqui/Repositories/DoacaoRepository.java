package com.GS.DoeAqui.Repositories;

import com.GS.DoeAqui.Models.Doacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repositório simulado em memória para gerenciar Doações.
 */
@Repository
public class DoacaoRepository {

    private final List<Doacao> doacoes = new ArrayList<>();
    private int currentId = 1;

    /**
     * Retorna a lista de todas as doações.
     * @return lista de doações
     */
    public List<Doacao> listarTodos() {
        return doacoes;
    }

    /**
     * Busca uma doação pelo seu código.
     * @param codigo código da doação
     * @return Optional contendo a doação, se encontrada
     */
    public Optional<Doacao> buscarPorId(int codigo) {
        return doacoes.stream()
                .filter(d -> d.getCodigo() == codigo)
                .findFirst();
    }

    /**
     * Adiciona uma nova doação e gera um código para ela.
     * @param doacao doação a ser adicionada
     * @return doação adicionada com código atribuído
     */
    public Doacao adicionar(Doacao doacao) {
        doacao.setCodigo(currentId++);
        doacoes.add(doacao);
        return doacao;
    }

    /**
     * Atualiza os dados de uma doação existente.
     * @param codigo código da doação a ser atualizada
     * @param dadosAtualizados dados para atualizar
     * @return true se atualizado com sucesso, false se não encontrada
     */
    public boolean atualizar(int codigo, Doacao dadosAtualizados) {
        Optional<Doacao> opt = buscarPorId(codigo);
        if (opt.isPresent()) {
            Doacao doacaoExistente = opt.get();
            doacaoExistente.setDoador(dadosAtualizados.getDoador());
            doacaoExistente.setTipoDoacao(dadosAtualizados.getTipoDoacao());
            doacaoExistente.setOrigem(dadosAtualizados.getOrigem());
            doacaoExistente.setDestino(dadosAtualizados.getDestino());
            return true;
        }
        return false;
    }

    /**
     * Remove uma doação pelo código.
     * @param codigo código da doação a ser removida
     * @return true se removido com sucesso, false se não encontrado
     */
    public boolean remover(int codigo) {
        return doacoes.removeIf(d -> d.getCodigo() == codigo);
    }
}
