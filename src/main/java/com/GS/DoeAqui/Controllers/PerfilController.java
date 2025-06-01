package com.GS.DoeAqui.Controllers;

import com.GS.DoeAqui.DTOs.LoginDTO;
import com.GS.DoeAqui.DTOs.PerfilDTO;
import com.GS.DoeAqui.DTOs.PerfilResponseDTO;
import com.GS.DoeAqui.Models.Perfil;
import com.GS.DoeAqui.Repositories.PerfilRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Controller REST para gerenciar perfis.
 */
@RestController
@RequestMapping("/perfis")
public class PerfilController {

    private final PerfilRepository perfilRepository;

    /**
     * Construtor para injeção do repositório.
     * @param perfilRepository repositório de perfis
     */
    public PerfilController(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    /**
     * Cria um novo perfil.
     * @param dto dados do perfil
     * @return mensagem de sucesso com ID do perfil criado
     */
    @PostMapping
    public ResponseEntity<?> criarPerfil(@RequestBody PerfilDTO dto) {
        Perfil perfil = dto.toPerfil();
        perfilRepository.salvar(perfil);
        return ResponseEntity.ok("Perfil criado com sucesso. ID: " + perfil.getId());
    }

    /**
     * Loga na conta.
     * @return informações do perfil em formato de resposta segura
     */
    @PostMapping("/login")
    public ResponseEntity<?> logarNaConta(@RequestBody LoginDTO loginRequest) {
        for (Perfil perfil : perfilRepository.listarTodos()) {
            if (loginRequest.getLogin() != null &&
                    perfil.getLogin() != null &&
                    perfil.getLogin().equals(loginRequest.getLogin()) &&
                    perfil.getSenha() != null &&
                    perfil.getSenha().equals(loginRequest.getSenha())) {

                PerfilResponseDTO dto = new PerfilResponseDTO(perfil);
                return ResponseEntity.ok(dto);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Login ou senha inválidos.");
    }


    /**
     * Busca um perfil pelo ID.
     * @param id identificador do perfil
     * @return perfil encontrado ou mensagem de erro
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        Optional<Perfil> optionalPerfil = perfilRepository.buscarPorId(id);

        if (optionalPerfil.isPresent()) {
            PerfilResponseDTO dto = new PerfilResponseDTO(optionalPerfil.get());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(404).body("Perfil não encontrado para o ID: " + id);
        }
    }



    /**
     * Atualiza um perfil pelo ID.
     * @param id identificador do perfil
     * @param dto dados atualizados do perfil
     * @return mensagem de sucesso ou erro
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPerfil(@PathVariable int id, @RequestBody PerfilDTO dto) {
        boolean atualizado = perfilRepository.atualizar(id, dto.toPerfil());
        if (atualizado) {
            return ResponseEntity.ok("Perfil atualizado com sucesso.");
        }
        return ResponseEntity.status(404).body("Perfil não encontrado para o ID: " + id);
    }

    /**
     * Remove um perfil pelo ID.
     * @param id identificador do perfil
     * @return mensagem de sucesso ou erro
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerPerfil(@PathVariable int id) {
        boolean removido = perfilRepository.remover(id);
        if (removido) {
            return ResponseEntity.ok("Perfil removido com sucesso.");
        }
        return ResponseEntity.status(404).body("Perfil não encontrado para o ID: " + id);
    }
}
