package com.GS.DoeAqui.Repositories;

import com.GS.DoeAqui.Models.Necessidade;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Repositório em memória para Necessidade.
 */
@Repository
public class NecessidadeRepository {

    private final Map<Integer, Necessidade> database = new HashMap<>();
    private int nextId = 1;

    public List<Necessidade> findAll() {
        return new ArrayList<>(database.values());
    }

    public Optional<Necessidade> findById(int id) {
        return Optional.ofNullable(database.get(id));
    }

    public Necessidade save(Necessidade necessidade) {
        if (necessidade.getId() == 0) {
            necessidade.setId(nextId++);
        }
        database.put(necessidade.getId(), necessidade);
        return necessidade;
    }

    public void deleteById(int id) {
        database.remove(id);
    }
}
