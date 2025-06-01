package com.GS.DoeAqui.Controllers;

import com.GS.DoeAqui.DTOs.RotaDTO;
import com.GS.DoeAqui.Models.Rota;
import com.GS.DoeAqui.Repositories.RotaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller REST para gerenciar operações CRUD sobre rotas.
 */
@RestController
@RequestMapping("/rotas")
public class RotaController {

    private final RotaRepository rotaRepository;

    /**
     * Construtor para injetar o repositório de rotas.
     * @param rotaRepository repositório de rotas
     */
    public RotaController(RotaRepository rotaRepository) {
        this.rotaRepository = rotaRepository;
    }

    /**
     * Endpoint para criação de uma nova rota.
     * @param dto dados da rota a ser criada
     * @return mensagem de sucesso com código da rota
     */
    @PostMapping
    public ResponseEntity<?> criarRota(@RequestBody RotaDTO dto) {
        Rota rota = new Rota();
        rota.setOrigem(dto.getOrigem());
        rota.setDestino(dto.getDestino());
        rota.setStatus(dto.getStatus());
        rota.setRotaDeEntrega(dto.getRotaDeEntrega());
        rota.setEntregadorResponsavel(dto.getEntregadorResponsavel());
        // Mapeamento da listaDeDoacoes pode ser feito aqui

        rotaRepository.adicionar(rota);
        return ResponseEntity.ok("Rota criada com sucesso. Código: " + rota.getCodigoAcompanhamento());
    }

    /**
     * Endpoint para listar todas as rotas.
     * @return lista com todas as rotas cadastradas
     */
    @GetMapping
    public ResponseEntity<List<Rota>> listarRotas() {
        return ResponseEntity.ok(rotaRepository.listarTodas());
    }

    /**
     * Endpoint para buscar uma rota pelo código de acompanhamento.
     * @param codigo código da rota
     * @return rota encontrada ou mensagem de erro se não encontrada
     */
    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPorCodigo(@PathVariable int codigo) {
        Optional<Rota> rota = rotaRepository.buscarPorCodigo(codigo);
        if (rota.isPresent()) {
            return ResponseEntity.ok(rota.get());
        }
        return ResponseEntity.status(404).body("Rota não encontrada para o código: " + codigo);
    }

    /**
     * Endpoint para atualizar os dados de uma rota.
     * @param codigo código da rota
     * @param dto dados atualizados da rota
     * @return mensagem de sucesso ou erro se rota não encontrada
     */
    @PutMapping("/{codigo}")
    public ResponseEntity<?> atualizarRota(@PathVariable int codigo, @RequestBody RotaDTO dto) {
        boolean atualizado = rotaRepository.atualizar(codigo, dto);
        if (atualizado) {
            return ResponseEntity.ok("Rota atualizada com sucesso.");
        }
        return ResponseEntity.status(404).body("Rota não encontrada para o código: " + codigo);
    }

    /**
     * Endpoint para remover uma rota pelo código.
     * @param codigo código da rota
     * @return mensagem de sucesso ou erro se rota não encontrada
     */
    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> removerRota(@PathVariable int codigo) {
        boolean removido = rotaRepository.remover(codigo);
        if (removido) {
            return ResponseEntity.ok("Rota removida com sucesso.");
        }
        return ResponseEntity.status(404).body("Rota não encontrada para o código: " + codigo);
    }
}
