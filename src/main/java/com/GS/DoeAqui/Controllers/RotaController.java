package com.GS.DoeAqui.Controllers;

import com.GS.DoeAqui.Models.Rota;
import com.GS.DoeAqui.Repositories.RotaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    private final RotaRepository rotaRepository = new RotaRepository();


    @PostMapping("/buscar")
    public ResponseEntity<?> buscarPorCodigo(@RequestParam int codigoAcompanhamento) {
        Optional<Rota> rotaEncontrada = rotaRepository.buscarPorCodigo(codigoAcompanhamento);

        if (rotaEncontrada.isPresent()) {
            return ResponseEntity.ok(rotaEncontrada.get());
        } else {
            return ResponseEntity.status(404).body("Rota não encontrada para o código: " + codigoAcompanhamento);
        }
    }
}
