package com.GS.DoeAqui.Repositories;

import com.GS.DoeAqui.Models.Perfil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Repositório para gerenciar perfis em memória.
 */
@Repository
public class PerfilRepository {

    /** Lista interna que armazena os perfis */
    private final List<Perfil> perfis = new ArrayList<>();

    /** Gerador automático de IDs para perfis */
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    /**
     * Salva um novo perfil, atribuindo um ID automaticamente.
     * @param perfil perfil a ser salvo
     */
    public void salvar(Perfil perfil) {
        perfil.setId(idGenerator.getAndIncrement());
        perfis.add(perfil);
    }

    /**
     * Busca um perfil pelo seu ID.
     * @param id identificador do perfil
     * @return Optional contendo o perfil ou vazio se não encontrado
     */
    public Optional<Perfil> buscarPorId(int id) {
        return perfis.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    /**
     * Busca um perfil pelo login.
     * @param login login do perfil
     * @return Optional contendo o perfil ou vazio se não encontrado
     */
    public Optional<Perfil> buscarPorLogin(String login) {
        return perfis.stream()
                .filter(p -> p.getLogin().equals(login))
                .findFirst();
    }

    /**
     * Atualiza os dados de um perfil existente.
     * @param id id do perfil a atualizar
     * @param perfilAtualizado dados atualizados do perfil
     * @return true se atualizado, false se perfil não encontrado
     */
    public boolean atualizar(int id, Perfil perfilAtualizado) {
        Optional<Perfil> perfilExistente = buscarPorId(id);
        if (perfilExistente.isPresent()) {
            Perfil perfil = perfilExistente.get();
            perfil.setNome(perfilAtualizado.getNome());
            perfil.setEndereco(perfilAtualizado.getEndereco());
            perfil.setCidade(perfilAtualizado.getCidade());
            perfil.setEstado(perfilAtualizado.getEstado());
            perfil.setNecessidade(perfilAtualizado.getNecessidade());
            perfil.setNomeONG(perfilAtualizado.getNomeONG());
            perfil.setRotaDeEntrega(perfilAtualizado.getRotaDeEntrega());
            perfil.setTipoVeiculo(perfilAtualizado.getTipoVeiculo());
            perfil.setTipoPerfil(perfilAtualizado.getTipoPerfil());
            return true;
        }
        return false;
    }

    /**
     * Remove um perfil pelo ID.
     * @param id id do perfil a remover
     * @return true se removido, false se não encontrado
     */
    public boolean remover(int id) {
        return perfis.removeIf(p -> p.getId() == id);
    }

    /**
     * Lista todos os perfis cadastrados.
     * @return lista de perfis
     */
    public List<Perfil> listarTodos() {
        return new ArrayList<>(perfis);
    }
}
