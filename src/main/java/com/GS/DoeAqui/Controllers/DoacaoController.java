package com.GS.DoeAqui.Controllers;

import com.GS.DoeAqui.DTOs.DoacaoDTO;
import com.GS.DoeAqui.DTOs.DoacaoResponseDTO;
import com.GS.DoeAqui.Models.Doacao;
import com.GS.DoeAqui.Models.Perfil;
import com.GS.DoeAqui.Models.Rota;
import com.GS.DoeAqui.Repositories.DoacaoRepository;
import com.GS.DoeAqui.Repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Controller REST para gerenciar operações CRUD de Doações.
 */
@RestController
@RequestMapping("/doacoes")
public class DoacaoController {

    @Autowired
    private DoacaoRepository doacaoRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    /**
     * Lista todas as doações.
     * @return lista de DoacaoResponseDTO
     */
    @GetMapping
    public ResponseEntity<List<DoacaoResponseDTO>> listarDoacoes() {
        List<DoacaoResponseDTO> dtos = doacaoRepository.listarTodos().stream()
                .map(DoacaoResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    /**
     * Busca uma doação pelo código.
     * @param codigo código da doação
     * @return DoacaoResponseDTO ou mensagem de erro se não encontrado
     */
    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPorId(@PathVariable int codigo) {
        Optional<Doacao> doacao = doacaoRepository.buscarPorId(codigo);
        if (doacao.isPresent()) {
            return ResponseEntity.ok(doacao.get());
        }
        return ResponseEntity.status(404).body("Doação não encontrada para o código: " + codigo);
    }


    /**
     * Cria uma nova doação.
     * @param dto dados da doação para criação
     * @return DoacaoResponseDTO ou mensagem de erro se perfil não encontrado
     */
    @PostMapping
    public ResponseEntity<?> criarDoacao(@RequestBody DoacaoDTO dto) {
        Perfil doador = perfilRepository.buscarPorId(dto.getDoadorId()).orElse(null);
        if (doador == null) {
            return ResponseEntity.badRequest().body("Perfil do doador não encontrado.");
        }

        Doacao doacao = new Doacao();
        doacao.setDoador(doador);
        doacao.setTipoDoacao(dto.getTipoDoacao());
        doacao.setOrigem(dto.getOrigem());
        doacao.setDestino(dto.getDestino());

        doacaoRepository.adicionar(doacao);
        return ResponseEntity.ok(new DoacaoResponseDTO(doacao));
    }

    /**
     * Atualiza uma doação existente.
     * @param codigo código da doação a atualizar
     * @param dto dados atualizados
     * @return mensagem de sucesso ou erro
     */
    @PutMapping("/{codigo}")
    public ResponseEntity<?> atualizarDoacao(@PathVariable int codigo, @RequestBody DoacaoDTO dto) {
        Perfil doador = perfilRepository.buscarPorId(dto.getDoadorId()).orElse(null);
        if (doador == null) {
            return ResponseEntity.badRequest().body("Perfil do doador não encontrado.");
        }

        Doacao dadosAtualizados = new Doacao();
        dadosAtualizados.setDoador(doador);
        dadosAtualizados.setTipoDoacao(dto.getTipoDoacao());
        dadosAtualizados.setOrigem(dto.getOrigem());
        dadosAtualizados.setDestino(dto.getDestino());

        boolean atualizado = doacaoRepository.atualizar(codigo, dadosAtualizados);
        if (atualizado) {
            return ResponseEntity.ok("Doação atualizada com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Doação não encontrada com o código: " + codigo);
        }
    }

    /**
     * Remove uma doação pelo código.
     * @param codigo código da doação a ser removida
     * @return mensagem de sucesso ou erro
     */
    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> removerDoacao(@PathVariable int codigo) {
        boolean removido = doacaoRepository.remover(codigo);
        if (removido) {
            return ResponseEntity.ok("Doação removida com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Doação não encontrada com o código: " + codigo);
        }
    }
}
