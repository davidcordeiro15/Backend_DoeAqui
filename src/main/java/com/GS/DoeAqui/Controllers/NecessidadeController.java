package com.GS.DoeAqui.Controllers;

import com.GS.DoeAqui.DTOs.NecessidadeDTO;
import com.GS.DoeAqui.Models.Necessidade;
import com.GS.DoeAqui.Repositories.NecessidadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller REST para Necessidades.
 */
@RestController
@RequestMapping("/necessidades")
public class NecessidadeController {

    private final NecessidadeRepository repository = new NecessidadeRepository();

    /**
     * Cria uma nova necessidade.
     */
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Necessidade> criarNecessidade(@RequestBody NecessidadeDTO dto) {
        Necessidade n = fromDTO(dto);
        Necessidade salva = repository.save(n);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    /**
     * Retorna todas as necessidades cadastradas.
     */
    @GetMapping
    public List<Necessidade> listarTodas() {
        return repository.findAll();
    }

    /**
     * Retorna uma necessidade específica por ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Necessidade> buscarPorId(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Atualiza uma necessidade por ID.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Necessidade> atualizar(@PathVariable int id, @RequestBody NecessidadeDTO dto) {
        return repository.findById(id).map(necessidade -> {
            necessidade.setIdDonatario(dto.getIdDonatario());
            necessidade.setListaDeItens(dto.getListaDeItens());
            necessidade.setQuantidadeaDePessoasAfetadas(dto.getQuantidadeaDePessoasAfetadas());
            necessidade.setLocalDeEntrega(dto.getLocalDeEntrega());
            repository.save(necessidade);
            return ResponseEntity.ok(necessidade);
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Exclui uma necessidade pelo ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private Necessidade fromDTO(NecessidadeDTO dto) {
        Necessidade n = new Necessidade();
        n.setIdDonatario(dto.getIdDonatario());
        n.setListaDeItens(dto.getListaDeItens());
        n.setQuantidadeaDePessoasAfetadas(dto.getQuantidadeaDePessoasAfetadas());
        n.setLocalDeEntrega(dto.getLocalDeEntrega());
        return n;
    }
}
