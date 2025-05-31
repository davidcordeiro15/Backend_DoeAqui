package com.GS.DoeAqui.Controllers;

import com.GS.DoeAqui.DTOs.LoginDTO;
import com.GS.DoeAqui.Models.Entregador;
import com.GS.DoeAqui.Repositories.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class EntregadorController {

    private final EntregadorRepository entregadorRepository;

    @Autowired
    public EntregadorController(EntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
    }

    // Criar um constructor login geral, porém precisamos de um banco
    @PostMapping("/login")
    public ResponseEntity<?> getEntregador(@RequestBody LoginDTO loginRequest) {
        for (Entregador entregador : entregadorRepository.findAll()) {
            if (loginRequest.getLogin() != null &&
                    entregador.getLogin() != null &&
                    entregador.getLogin().equals(loginRequest.getLogin()) &&
                    entregador.getSenha() != null &&
                    entregador.getSenha().equals(loginRequest.getSenha())) {
                return ResponseEntity.ok(entregador);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Login ou senha inválidos.");
    }


}
